package com.example.mycities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] name={"CHICAGO", "NEW YORK", "LOS ANGELES", "SAN FRANCISCO"};
    String[] nickname={"The Windy City", "The City that Never Sleeps", "The City of Angels", "The Golden City"};
    Integer[] imgid={
        R.drawable.chicago,
        R.drawable.newyork,
        R.drawable.losangeles,
        R.drawable.sanfrancisco
    };
    String[] address={"https://www.chicago.gov/","https://www.nyc.gov/", "https://www.lacity.org/", "https://sf.gov/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter adapter=new CustomListAdapter(this, name, nickname, imgid);
        list=findViewById(R.id.list);
        list.setEmptyView(findViewById(R.id.empty));
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(address[i]));
                startActivity(intent);
            }
        });
    }
}