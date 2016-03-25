# react-native-wallpapermanager

npm install rnpm --global

npm install https://github.com/yulinho/react-native-wallpapermanager --save

rnpm link react-native-wallpapermanager


//WallpaperManager 

usage:

add permission <uses-permission android:name="android.permission.SET_WALLPAPER" />

	import WallpaperManager  from  'react-native-wallpapermanager' 
    WallpaperManager.setWallpaper({
      bitmapUri:uri
    },function(res){
    	console.log(res)
    	})

