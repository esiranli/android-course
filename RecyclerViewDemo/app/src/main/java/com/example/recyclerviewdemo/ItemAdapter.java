package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final ArrayList<Student> students;
    public ItemAdapter(ArrayList<Student> items) {
        this.students = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Student student = students.get(position);
        holder.firstLineTextView.setText(student.getName());
        holder.secondLineTextView.setText(student.getRole());
        holder.icon.setImageResource(student.getImageResource());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView firstLineTextView;
        TextView secondLineTextView;
        ImageView icon;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            firstLineTextView = itemView.findViewById(R.id.firstLine);
            secondLineTextView = itemView.findViewById(R.id.secondLine);
            icon = itemView.findViewById(R.id.imageView);
        }
    }
}


