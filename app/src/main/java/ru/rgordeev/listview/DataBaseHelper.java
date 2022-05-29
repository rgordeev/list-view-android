package ru.rgordeev.listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, "persons.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.personEntry.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("delete from persons");
        db.execSQL("insert into persons(name, phone) values('Ivane','+79000000000')");
        db.execSQL("insert into persons(name, phone) values('Ivane','+79000000000')");
        db.execSQL("insert into persons(name, phone) values('Ivane','+79000000000')");
    }
}
