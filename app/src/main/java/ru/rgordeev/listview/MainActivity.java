package ru.rgordeev.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper = new DataBaseHelper(getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.list);

        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayout);

        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), DataManager.fetchAllPersons(dataBaseHelper)));
    }
}