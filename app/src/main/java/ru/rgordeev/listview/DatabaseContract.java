package ru.rgordeev.listview;

import android.provider.BaseColumns;

public class DatabaseContract {

    final static DatabaseContract contract = new DatabaseContract();
    final static PersonEntry personEntry = contract.new PersonEntry();

    class PersonEntry implements BaseColumns {


        final String TABLE_NAME = "persons";
        final String COLUMN_ID = _ID;
        final String COLUMN_NAME = "name";
        final String COLUMN_PHONE = "phone";

        final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_PHONE + " TEXT NOT NULL)";

    }
}
