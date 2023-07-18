package com.example.listviewdemo2;

import android.view.View;

/*
This interface is a custom listener that listens delete button click on
 a fruit list item and informs caller by returning item's view and position
 */
public interface FruitListItemDeleteButtonClickListener {
    void onDeleteButtonClick(View view, int position);
}
