package com.dhanashri.app.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dhanashri.app.entities.User;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "classwork", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_user = "CREATE TABLE user(id Integer PRIMARY KEY AUTOINCREMENT,name TEXT, email TEXT, password TEXT ) ";
        db.execSQL(sql_user);

    }

    public void insertUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        db.insert("user", null, values);
    }

    public User getUser(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("user", null, "email = ? AND password = ?", new String[]{email, password}, null, null, null);
        if (cursor.moveToNext()){
           User user = new User();
           user.setId(cursor.getInt(0));
           user.setName(cursor.getString(1));
           user.setEmail(email);
           user.setPassword(password);
           return user;
        }
        return null;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
