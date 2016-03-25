package com.yulinho.reactnativewallpapermanager;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.net.Uri;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import java.util.ArrayList;
import android.widget.Toast;

import android.graphics.Bitmap; 
import android.provider.MediaStore;  
import android.app.WallpaperManager;

public class WallpaperManagerManager extends ReactContextBaseJavaModule {

  public WallpaperManagerManager(ReactApplicationContext reactContext) {
    super(reactContext);
  }

 private Bitmap getBitmapFromUri(Uri uri)
   {
    try
    {
     // 读取uri所在的图片
     Bitmap bitmap = MediaStore.Images.Media.getBitmap(getReactApplicationContext().getContentResolver(), uri);
     return bitmap;
    }
    catch (Exception e)
    {
     //Log.e("[Android]", e.getMessage());
     //Log.e("[Android]", "目录为：" + uri);
     e.printStackTrace();
     return null;
    }
   }

  @ReactMethod
  public void show1(final Callback callback){
    Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    WritableMap response = Arguments.createMap();

      response.putString("ok1", "can't find current Activity");
      callback.invoke(response);
      
  } 
  @ReactMethod
  public void setWallpaper(final ReadableMap options, final Callback callback){

    //Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    WritableMap response = Arguments.createMap();

    if (options.hasKey("uri")) {

      Uri uri = Uri.parse(options.getString("uri")); 
      Bitmap bitmap = getBitmapFromUri(uri);
      WallpaperManager manager = WallpaperManager.getInstance(getReactApplicationContext());

    try
    {
      manager.setBitmap(bitmap);
    }
    catch (Exception e)
    {
     //Log.e("[Android]", e.getMessage());
     //Log.e("[Android]", "目录为：" + uri);
     e.printStackTrace();
     //return null;
    }
      
      //Toast.makeText(getReactApplicationContext(), options.getString("title"), Toast.LENGTH_LONG).show();
    }

      response.putString("ok", "can't find current Activity");
      callback.invoke(response);
      
  }


  @Override
  public String getName() {
    return "ReactNativeWallpaperManager";
  }
}
