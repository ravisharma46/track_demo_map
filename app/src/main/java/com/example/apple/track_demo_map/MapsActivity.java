package com.example.apple.track_demo_map;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;

import static com.example.apple.track_demo_map.R.id;
import static com.example.apple.track_demo_map.R.layout;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ImageView imageView_car,imageView_tool,imageView_toolDone,imageView_carDrop;

    private int animationCounter = 1;
    private Handler imageSwitcherHandler;
    private RelativeLayout relativeLayout;

    Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(id.map);
        mapFragment.getMapAsync(this);

        imageView_car=(ImageView)findViewById(id.car_pick);
        imageView_tool=(ImageView)findViewById(id.tool_pick);
        imageView_toolDone=(ImageView)findViewById(id.tool_done);
        imageView_carDrop=(ImageView)findViewById(id.car_drop);


//     imageView_car.setImageResource(R.drawable.car_svg);
//     imageView_tool.setImageResource(R.drawable.tool_svg);
//     imageView_toolDone.setImageResource(R.drawable.tool_done_svg);
//     imageView_carDrop.setImageResource(R.drawable.cardrop_svg);





        imageSwitcherHandler = new Handler(Looper.getMainLooper());
        imageSwitcherHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++) {
                    case 1:
                       // imageView_car.setImageResource(R.drawable.car_svg);
                       // imageSwitcher.setImageResource(R.drawable.image1);
                        break;
                    case 2:
                       // imageView_tool.setImageResource(R.drawable.tool_svg);
                        //imageSwitcher.setImageResource(R.drawable.image2);
                        break;
                    case 3:
                       // imageView_toolDone.setImageResource(R.drawable.tool_done_svg);
                        //imageSwitcher.setImageResource(R.drawable.image3);
                   // case 4:
                     //   imageView_carDrop.setImageResource(R.drawable.cardrop_svg);
                        //imageSwitcher.setImageResource(R.drawable.image3);

                        break;
                }
                animationCounter %= 4;
               if(animationCounter == 0 ) animationCounter = 1;

                imageSwitcherHandler.postDelayed(this, 2000);
            }
        });


//        relativeLayout = (RelativeLayout) findViewById(R.id.seek_bar);
//      //  AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
//        //animationDrawable.start();
//
//        ScaleAnimation fade_in =  new ScaleAnimation(0f, 1f, 0f, 1f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        fade_in.setDuration(9000);     // animation duration in milliseconds
//        fade_in.setFillAfter(true);    // If fillAfter is true, the transformation that this animation performed will persist when it is finished.
//        relativeLayout.startAnimation(fade_in);




    }






    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
