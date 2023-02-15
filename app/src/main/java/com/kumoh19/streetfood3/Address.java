//package com.kumoh19.streetfood3;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.ViewModelProvider;
//
//import android.content.Context;
//import android.content.Intent;
//import android.location.Geocoder;
//import android.os.Bundle;
//import android.text.Layout;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.kumoh19.streetfood3.databinding.FragmentHomeBinding;
//
//import net.daum.mf.map.api.MapPOIItem;
//import net.daum.mf.map.api.MapPoint;
//import net.daum.mf.map.api.MapReverseGeoCoder;
//import net.daum.mf.map.api.MapView;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class Address extends AppCompatActivity implements MapReverseGeoCoder.ReverseGeoCodingResultListener {
//
//    private GpsTracker gpsTracker;
//    private HomeActivity HomeActivity;
//    private FragmentHomeBinding binding;
//    public String ADR;
//
//    public static Context context;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_address);
//
//        context = this;
//        MapView mapView = new MapView(this);
//        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
//        mapViewContainer.addView(mapView);
//
//        gpsTracker = new GpsTracker(this);
//
//        double latitude = gpsTracker.getLatitude();
//        double longitude = gpsTracker.getLongitude();
//
//        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);
//        // 줌 레벨 변경
//        mapView.setZoomLevel(2, true);
//
//        //마커 찍기
//        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(latitude, longitude);
//        MapPOIItem marker = new MapPOIItem();
//        marker.setItemName("현재위치");
//        marker.setTag(0);
//        marker.setMapPoint(MARKER_POINT);
//        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
//        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
//
//        mapView.addPOIItem(marker);
//
//        MapReverseGeoCoder mapGeoCoder = new MapReverseGeoCoder( "312c2631f940e1e1b41dad098ccae072", MARKER_POINT, this, this );
//        mapGeoCoder.startFindingAddress();
//
//        Button register_btn = (Button)findViewById(R.id.register);
//        register_btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Log.i("HomeActivity", "ADR : " + ADR);
//                finish();
////                Intent intent = new Intent(Address.this, HomeActivity.class);
////                intent.putExtra("address", ADR);
////                startActivity(intent);
//            }
//        });
//    }
//
//
//    @Override
//    public void onReverseGeoCoderFailedToFindAddress( MapReverseGeoCoder arg)
//    {
//        Toast.makeText(this, "주소를 찾는데 실패했습니다", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder arg0, String str)
//    {
//        TextView address_name = (TextView) findViewById(R.id.address_name);
//        address_name.setText(str);
//        ADR = str;
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//
//}