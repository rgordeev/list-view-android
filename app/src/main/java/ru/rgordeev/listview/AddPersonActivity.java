package ru.rgordeev.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddPersonActivity extends AppCompatActivity {

    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update);

        dataBaseHelper = new DataBaseHelper(getApplicationContext());

        AppCompatEditText name = findViewById(R.id.name);
        AppCompatEditText phone = findViewById(R.id.phone);

        Button save = findViewById(R.id.bSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;
                if (name.getText().toString().isEmpty()) {
                    name.setError("Required Field");
                    valid = false;
                }
                if (phone.getText().toString().isEmpty()) {
                    phone.setError("Required Field");
                    valid = false;
                }
                if (valid) {
                    String n = name.getText().toString();
                    String p = phone.getText().toString();

                    SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.personEntry.COLUMN_NAME, n);
                    values.put(DatabaseContract.personEntry.COLUMN_PHONE, p);

                    long result = db.insert(DatabaseContract.personEntry.TABLE_NAME, null, values);

                    setResult(RESULT_OK);

                    Toast.makeText(getApplicationContext(), "Employee Added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button cancel = findViewById(R.id.bCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}