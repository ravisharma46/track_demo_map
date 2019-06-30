package com.example.apple.track_demo_map;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

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
    private Button bt;
    private ProgressBar progressBar;



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

        bt=(Button)findViewById(id.buttonPanel);


        progressBar = (ProgressBar)findViewById(id.progressbar1);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MapsActivity.this,job_table.class);
                startActivity(i);
            }
        });



        progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.SRC_IN);

        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 70);

       animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
           @Override
           public void onAnimationUpdate(ValueAnimator valueAnimator) {
               int val = (Integer) valueAnimator.getAnimatedValue();
              // Log.e("TAG",Integer.toString(val));
               if(val==35){
                imageView_car.setImageResource(R.drawable.car_svg);
            }
            if(val==45){
                imageView_tool.setImageResource(R.drawable.tool_svg);
            }
            if(val==55){
                imageView_toolDone.setImageResource(R.drawable.tool_done_svg);
            }
            if(val==70){
                imageView_carDrop.setImageResource(R.drawable.cardrop_svg);
            }


           }
       });

        animation.setDuration(4000);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();







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
