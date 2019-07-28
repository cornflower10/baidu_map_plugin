package com.cornflower.baidu_map_plugin;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformView;

/**
 * Created by xiejingbao on 2019/7/26.
 */
public class BaiduMapView implements PlatformView, MethodChannel.MethodCallHandler {
    private MapView mapView;
    private PluginRegistry.Registrar registrar;
    private MethodChannel methodChannel;
    private Context context;

    public BaiduMapView(Context context, int viewId, Object o, PluginRegistry.Registrar registor) {
        this.registrar = registor;
        mapView = new MapView(context);
        this.methodChannel = new MethodChannel(registor.messenger(), "baidu_map_" + viewId);
        this.methodChannel.setMethodCallHandler(this);
        this.context = context;

    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        switch (methodCall.method) {
            case "startLocation":
                initMap();
                break;
        }
//        methodCall.method
    }

    boolean isFirst = true;

    private void initMap() {

        final BaiduMap baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        LocationClient locationClient = new LocationClient(context);
        locationClient.registerLocationListener(new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {


                baiduMap.setMyLocationData(new MyLocationData.Builder().accuracy(bdLocation.getRadius())
                        .direction(bdLocation.getDirection())
                        .longitude(bdLocation.getLongitude())
                        .latitude(bdLocation.getLatitude()).build());
                Log.i("BaiduMapView",bdLocation.getAddrStr());

                if (isFirst) {
                    isFirst = false;
                    MapStatusUpdate statusUpdate =  MapStatusUpdateFactory.newLatLngZoom(
                            new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude()), 17f);
                    baiduMap.animateMapStatus(statusUpdate);
                }
            }
        });
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);  // 打开gps
        option.setCoorType("bd09ll") ;// 设置坐标类型
        option.setScanSpan(5000);
        locationClient.setLocOption(option);
        locationClient.start();
    }

    @Override
    public View getView() {
        return mapView;
    }

    @Override
    public void dispose() {

    }
}
