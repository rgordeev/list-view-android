package ru.rgordeev.listview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManager {
    public static List<Person> fetchAllPersons(DataBaseHelper dataBaseHelper) {
        List<Person> result = new ArrayList<>();

        SQLiteDatabase database = dataBaseHelper.getReadableDatabase();

        String[] columns = new String[]{
                DatabaseContract.personEntry.COLUMN_ID,
                DatabaseContract.personEntry.COLUMN_NAME,
                DatabaseContract.personEntry.COLUMN_PHONE
        };

        Cursor cursor = database.query(DatabaseContract.personEntry.TABLE_NAME, columns, null, null, null, null, null);
        int idPos = cursor.getColumnIndex(DatabaseContract.personEntry.COLUMN_ID);
        int namePos = cursor.getColumnIndex(DatabaseContract.personEntry.COLUMN_NAME);
        int phonePos = cursor.getColumnIndex(DatabaseContract.personEntry.COLUMN_PHONE);

        while (cursor.moveToNext()) {
            String id = cursor.getString(idPos);
            String name = cursor.getString(namePos);
            String phone =  cursor.getString(phonePos);

            result.add(new Person(id, name, phone));

        }

        return result;
    }
}
