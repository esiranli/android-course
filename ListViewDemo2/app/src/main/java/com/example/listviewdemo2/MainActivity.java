package com.example.listviewdemo2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
    private ArrayAdapter<String> adapter;
    private FruitListAdapter fruitListAdapter;
    private ArrayList<String> items;
    private ArrayList<String> fruitNames;
    private ArrayList<Integer> imageNames;
    private int lastIndex;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.listView);

        // This creates initially 20 items to show in the list like "Item i"
//        items = new ArrayList<>();
//        lastIndex = 0;
//        for (int i = 0; i < 20; i++) {
//            items.add("Item " + (i + 1));
//            lastIndex++;
//        }

        // This creates adapter to show each item in the list on a layout named simple_list_item_1
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
//        myListView.setAdapter(adapter);

        fruitNames = new ArrayList<String>(Arrays.asList("Ananas", "Apple", "Banana", "Grapes", "Pomegranate"));
        imageNames = new ArrayList<Integer>(Arrays.asList(R.drawable.ananas, R.drawable.apple, R.drawable.banana, R.drawable.grapes, R.drawable.pomegranate));
        lastIndex = fruitNames.size();
        fruitListAdapter = new FruitListAdapter(this, fruitNames, imageNames);
        myListView.setAdapter(fruitListAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                CharSequence message = "Selected item: " + items.get(position);
                CharSequence message = "Selected item: " + fruitNames.get(position);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_button) {
            // TODO: add new item
            Log.d("onOptionsItemSelected", "Add button is pressed");
//            items.add("Item " + (lastIndex + 1));
//            lastIndex++;
//            adapter.notifyDataSetChanged();

            fruitNames.add("Apple");
            imageNames.add(R.drawable.apple);
            lastIndex++;
            fruitListAdapter.notifyDataSetChanged();
            myListView.smoothScrollToPosition(lastIndex + 1);
        }
        return super.onOptionsItemSelected(item);
    }
}
