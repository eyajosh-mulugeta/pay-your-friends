package com.eyasumulugeta.pyf.activities.controllers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.eyasumulugeta.pyf.activities.database.Database;
import com.eyasumulugeta.pyf.activities.utils.Utils;

import java.util.ArrayList;

public abstract class BaseController<T> {

    private ArrayList<T> items;
    protected String tableName;
    protected Cursor cursor;

    public BaseController(String tableName) {
        items = new ArrayList<>();
        this.tableName = tableName;
        load();
    }

    protected abstract void load();

    protected void fetchAll() {
        String sql = "SELECT * FROM " + tableName;
        cursor = openDatabase().rawQuery(sql, null);
    }

    public void add(T item) {
        items.add(item);
    }

    protected SQLiteDatabase openDatabase() {
        return Database.getInstance().getWritableDatabase();
    }

    protected void closeCursor() {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
            cursor = null;
        }
        d("Loaded: " + size());
    }

    public T get(int position) {
        return items.get(position);
    }

    public void add(ArrayList<T> other) {
        items.addAll(other);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    protected void sync(T item) {

    }

    protected void d(String message) {
        Utils.d(this, message);
    }
}
