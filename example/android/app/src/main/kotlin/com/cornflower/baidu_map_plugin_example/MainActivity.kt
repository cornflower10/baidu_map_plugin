package com.cornflower.baidu_map_plugin_example

import android.os.Bundle
import com.cornflower.baidu_map_plugin.BaiduMapPlugin
import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    BaiduMapPlugin.setContext(this)
    GeneratedPluginRegistrant.registerWith(this)
//      BaiduMapPlugin.register(this,this)

  }
}
