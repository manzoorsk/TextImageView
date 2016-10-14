package com.example.admin.textimageview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


     List<Car> myCars=new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=(ListView)findViewById(R.id.listView);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.activity_list_item,myCars);
        listView.setAdapter(adapter);

//        listView.setOnClickListener((View.OnClickListener) this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                Car car=(Car)adapterView.getItemAtPosition(i);
                Toast.makeText(view.getContext(),"Hii",Toast.LENGTH_LONG).show();

                if(i<=20) {
                    Intent intent = new Intent(view.getContext(), ListOfView.class);
                    intent.putExtra("id",i);
                    startActivity(intent);

                }
            }

        });
        populateCarList();
        populatListView();
    }



    private void populateCarList() {
        myCars.add(new Car("Ford",1994,R.drawable.icon_image,"Work Good"));
        myCars.add(new Car("Jeep",1991,R.drawable.icon_lief,"Good"));
        myCars.add(new Car("Honda",1999,R.drawable.icon_liefs,"Fast !"));
        myCars.add(new Car("Moon Lander",2005,R.drawable.icon_star,"Not very Good"));
        myCars.add(new Car("Toyota",2000,R.drawable.icon_tree,"Out of Stack"));
        myCars.add(new Car("Balloon",1995,R.drawable.icon_balloon,"Out of Stack"));
        myCars.add(new Car("Candle",1996,R.drawable.icon_candle,"Out of Stack"));
        myCars.add(new Car("Plant",2008,R.drawable.icon_plant,"Out of Stack"));
        myCars.add(new Car("Ribbon",2001,R.drawable.icon_ribbon,"Out of Stack"));
        myCars.add(new Car("Right",2003,R.drawable.icon_right,"Out of Stack"));
        myCars.add(new Car("Location",1990,R.drawable.icon_location,"Out of Stack"));
        myCars.add(new Car("Green",1989,R.drawable.icon_green,"Out of Stack"));



    }


    private void populatListView() {
        MyListAdapter adapter= new MyListAdapter();
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    private class MyListAdapter extends ArrayAdapter<Car>{
        public MyListAdapter(){
            super(MainActivity.this,R.layout.item_view,myCars);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView=convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }
            Car currentCar=myCars.get(position);
            ImageView imageview=(ImageView)itemView.findViewById(R.id.image);
            imageview.setImageResource(currentCar.getIconID());

            TextView makeText=(TextView)itemView.findViewById(R.id.item_make);
            makeText.setText(currentCar.getMake());

            TextView yearText=(TextView)itemView.findViewById(R.id.item_year);
            yearText.setText("" + currentCar.getYear());

            TextView conditionText=(TextView)itemView.findViewById(R.id.item_condition);
            conditionText.setText(currentCar.getCondition());

            return itemView;
        }

    }



}
