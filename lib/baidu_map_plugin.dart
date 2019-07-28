import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class BaiduMapPlugin {
  static MethodChannel _channel = null;


  static Future<void> startLocation() async {
    await _channel.invokeMethod('startLocation');
  }

  static init(int id) {
    _channel = MethodChannel('baidu_map_$id');
  }

}

class BdMap extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState

    return BdMapState();
  }

}

class BdMapState extends State<BdMap> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return native();
  }

  Widget native() {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(viewType: "baidu_map_plugin",
        onPlatformViewCreated: onPlatformViewCreated,);
    }
  }

  Future<void> onPlatformViewCreated(id) async {
     BaiduMapPlugin.init(id);
     BaiduMapPlugin.startLocation();

  }

}

