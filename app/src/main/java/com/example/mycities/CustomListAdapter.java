package com.example.mycities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final  Activity context;
    private final String[] name;
    private final String[] nickname;
    private final Integer[] imgid;


    public CustomListAdapter(@NonNull Activity context, String[] name, String[] nickname, Integer[] imgid) {
        super(context, R.layout.mylist, name);
        this.context = context;
        this.name = name;
        this.nickname=nickname;
        this.imgid = imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null, true);
        TextView textname=rowView.findViewById(R.id.name);
        TextView textnickname=rowView.findViewById(R.id.nickname);
        ImageView imgcity=rowView.findViewById(R.id.icon);

        textname.setText(name[position]);
        textnickname.setText(nickname[position]);
        imgcity.setImageResource(imgid[position]);


        return rowView;
    }
}
