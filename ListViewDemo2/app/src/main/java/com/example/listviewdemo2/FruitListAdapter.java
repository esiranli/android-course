package com.example.listviewdemo2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FruitListAdapter extends BaseAdapter {
    private ArrayList<String> fruitNames;
    private ArrayList<Integer> imageNames;
    private Context context;

    FruitListAdapter(Context context, ArrayList<String> fruitNames, ArrayList<Integer> imageNames) {
        this.context = context;
        this.fruitNames = fruitNames;
        this.imageNames = imageNames;
    }

    @Override
    public int getCount() {
        return fruitNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View fruitItemView = LayoutInflater.from(context).inflate(R.layout.fruit_list_item, null);
        ImageView imageView = fruitItemView.findViewById(R.id.imageView);
        imageView.setImageResource(imageNames.get(position));
        imageView.animate().alpha(0.5f);
        TextView textView = fruitItemView.findViewById(R.id.textView);
        textView.setText(fruitNames.get(position));
        return fruitItemView;
    }
}
