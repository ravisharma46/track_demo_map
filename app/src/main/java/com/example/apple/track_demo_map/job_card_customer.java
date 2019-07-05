package com.example.apple.track_demo_map;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class job_card_customer extends AppCompatActivity {

    private Button bt;
    private LinearLayout paint_linear;
    private TextView tvDetails,tv_1,tv_2,tv_3,tv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_card_customer);

        bt=(Button) findViewById(R.id.pay);
        paint_linear=(LinearLayout)findViewById(R.id.linear_paint);
        tvDetails=(TextView)findViewById(R.id.tvDetails);
        tv_1=(TextView)findViewById(R.id.tv_1);
        tv_2=(TextView)findViewById(R.id.tv_2);
        tv_3=(TextView)findViewById(R.id.tv_3);
        tv_4=(TextView)findViewById(R.id.tv_4);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Details</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.back_arrow);
        upArrow.setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);






        tv_1.setText("\u20B9"+" 3,200");
        tv_2.setText("\u20B9"+" 200");
        tv_3.setText("\u20B9"+" 100");
        tv_4.setText("\u20B9"+" 100");


        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check=1;
            @Override
            public void onClick(View view) {

                if(check==1){
                    paint_linear.setVisibility(View.VISIBLE);
                    check=0;
                }
                else{
                    paint_linear.setVisibility(View.GONE);
                    check=1;
                }


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
