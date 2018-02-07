package com.example.shaimaaderbaz.habittracker.activities;

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
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitDbHelper mDbHelper=new HabitDbHelper(this);
        SQLiteDatabase db=mDbHelper.getWritableDatabase();
        String [] habits=new String[2];
        habits[0] ="playing volleyball";
        habits [1]= "walk my dog";

        HabitDbHelper dbHelper=new HabitDbHelper(this);
        dbHelper.insertDBHabit(0,habits[0]);
        dbHelper.insertDBHabit(1,habits[1]);

        Cursor cursor=dbHelper.readDBHabits();
        String[] HabitsRead = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_DESCIPTION,
                HabitContract.HabitEntry.COLUMN_HABIT_DAILY
              };

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext())
        {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(HabitContract.HabitEntry._ID));
            itemIds.add(itemId);
            int habit1 =cursor.getInt(0);
            int habit2 =cursor.getInt(1);
            int habit3 =cursor.getInt(2);
            String []itemsCol=cursor.getColumnNames();

        }
        cursor.close();

    }
}
