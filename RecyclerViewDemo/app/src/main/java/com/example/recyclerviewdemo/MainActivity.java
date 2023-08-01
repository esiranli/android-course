package com.example.recyclerviewdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addButton;
    private final ArrayList<Student> students = new ArrayList<>();
    private ItemAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createStudents();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new ItemAdapter(students);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                Student student = students.remove(fromPosition);
                students.add(toPosition, student);
                adapter.notifyItemMoved(fromPosition, toPosition);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // TODO: show alert dialog
                int position = viewHolder.getAdapterPosition();
                Student student = students.remove(position);
                adapter.notifyItemRemoved(position);
                Snackbar.make(addButton, "Student " + student.getName() + " is deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                students.add(position, student);
                                adapter.notifyItemInserted(position);
                            }
                        }).show();
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);

        addButton = findViewById(R.id.fab);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: show custom dialog to add new student
            }
        });
    }

    private void createStudents() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student(R.drawable.ic_launcher_foreground, "Student", "Student " + i);
            students.add(student);
        }
    }
}
