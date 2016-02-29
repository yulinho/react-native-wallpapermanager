package com.yulinho.reactnativett;

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


public class TtManager extends ReactContextBaseJavaModule {

  public TtManager(ReactApplicationContext reactContext) {
    super(reactContext);
  }


  @ReactMethod
  public void show1(final Callback callback){
    Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    WritableMap response = Arguments.createMap();

      response.putString("ok1", "can't find current Activity");
      callback.invoke(response);
      
  }
  @ReactMethod
  public void show(final ReadableMap options, final Callback callback){
    Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    WritableMap response = Arguments.createMap();

    if (options.hasKey("title")) {
      
      Toast.makeText(getReactApplicationContext(), options.getString("title"), Toast.LENGTH_LONG).show();
    }

      response.putString("ok2", "can't find current Activity");
      callback.invoke(response);
      
  }


  @Override
  public String getName() {
    return "Tt";
  }
}
