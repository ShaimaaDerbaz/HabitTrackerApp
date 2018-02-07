package com.example.shaimaaderbaz.habittracker.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaimaaderbaz.habittracker.R;
import com.example.shaimaaderbaz.habittracker.contracts.HabitDbHelper;
import com.example.shaimaaderbaz.habittracker.contracts.HabitContract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitDbHelper mDbHelper=new HabitDbHelper(this);
        SQLiteDatabase db=mDbHelper.getWritableDatabase();
        String [] habits=new String[2];
        habits[0] ="playing volleyball";
        habits [1]= "walk my dog";
        for (int i=0;i<2;i++)
        {
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DESCIPTION,habits[i]);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DAILY, i);
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        }

        SQLiteDatabase dbRead = mDbHelper.getReadableDatabase();


        String[] HabitsRead = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_DESCIPTION,
                HabitContract.HabitEntry.COLUMN_HABIT_DAILY
              };


        String selection = HabitContract.HabitEntry.COLUMN_HABIT_DESCIPTION + " = ?";
        String[] selectionArgs = { habits[1] };

        String sortOrder =
                HabitContract.HabitEntry._ID + " DESC";

        Cursor cursor = dbRead.query(
                HabitContract.HabitEntry.TABLE_NAME,                     // The table to query
                HabitsRead,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        int c=cursor.getColumnCount();
        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(HabitContract.HabitEntry._ID));
            itemIds.add(itemId);
            String []itemsCol=cursor.getColumnNames();


        }
        cursor.close();

    }
}
