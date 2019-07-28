package com.cornflower.baidu_map_plugin

import android.content.Context
import io.flutter.plugin.common.PluginRegistry

class BaiduMapPlugin{

  companion object {
   private   lateinit var ctx:Context
   fun setContext(context:Context){
     ctx = context
    }
//    @JvmStatic
//    fun registerWith(registrar: PluginRegistry) {
////      val channel = MethodChannel(registrar.messenger(), "baidu_map_plugin")
//////      channel.setMethodCallHandler(BaiduMapPlugin())
//
//      val key = BaiduMapPlugin::class.java!!.getCanonicalName()
//
//
//      if (registrar.hasPlugin(key)) return;
//
//      var re= registrar.registrarFor(key);                //注册
//
//
//      re.platformViewRegistry()
//              .registerViewFactory("baidu_map_plugin", MapViewFactory(re,ctx));
//    }
    @JvmStatic
    fun registerWith(registrar: PluginRegistry.Registrar) {
//      val channel = MethodChannel(registrar.messenger(), "baidu_map_plugin")
////      channel.setMethodCallHandler(BaiduMapPlugin())

      val key = BaiduMapPlugin::class.java!!.getCanonicalName()


//      if (registrar.hasPlugin(key)) return;

      var re= registrar               //注册


      re.platformViewRegistry()
              .registerViewFactory("baidu_map_plugin", MapViewFactory(re,ctx));
    }
  }

//  override fun onMethodCall(call: MethodCall, result: Result) {
//    if (call.method == "getPlatformVersion") {
//      result.success("Android ${android.os.Build.VERSION.RELEASE}")
//    } else {
//      result.notImplemented()
//    }
//  }
}
