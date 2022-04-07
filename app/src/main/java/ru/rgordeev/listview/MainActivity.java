package ru.rgordeev.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);

        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayout);

        recyclerView.setAdapter(new MyAdapter(getApplicationContext()));
    }
}