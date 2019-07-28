package com.cornflower.baidu_map_plugin;

import android.content.Context;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * Created by xiejingbao on 2019/7/26.
 */
public class MapViewFactory extends PlatformViewFactory {
   private PluginRegistry.Registrar registrar;
   private Context context;

    public MapViewFactory(PluginRegistry.Registrar registrar,Context context) {
        super(StandardMessageCodec.INSTANCE);
        this.registrar = registrar;
        this.context =context;
    }

    @Override
    public PlatformView create(final Context context, int i, Object o) {
        return new BaiduMapView(this.context,i,o,registrar);
    }


}
