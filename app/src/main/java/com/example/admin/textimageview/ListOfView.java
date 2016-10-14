package com.example.admin.textimageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListOfView extends AppCompatActivity {

    ImageView image;
    TextView item_make,item_year,item_condition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_view);

        image=(ImageView)findViewById(R.id.image);
        item_make=(TextView)findViewById(R.id.item_make);
        item_year=(TextView)findViewById(R.id.item_year);
        item_condition=(TextView)findViewById(R.id.item_condition);

//        Intent i = getIntent();
//        String name=i.getExtras().getString("Item Make");
//        String name1=i.getExtras().getString("Item Year");
//        String name2=i.getExtras().getString("Item Condition");
//        int imag = i.getExtras().getInt("Image Key");
//
//        item_make.setText(name);
//        item_year.setText(name1);
//        item_condition.setText(name2);
//        image.setImageResource(imag);



    }


}
