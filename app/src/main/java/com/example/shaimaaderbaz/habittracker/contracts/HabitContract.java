package com.example.shaimaaderbaz.habittracker.contracts;

import android.provider.BaseColumns;

/**
 * Created by Shaimaa Derbaz on 2/6/2018.
 */

public final class HabitContract {

    private HabitContract() {}

    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habit";

        public static final String _ID= BaseColumns._ID;
        public static final String COLUMN_HABIT_DESCIPTION = "description";
        public static final String COLUMN_HABIT_DAILY = "isdaily";



    }
    }
