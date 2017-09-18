package db;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cyoste on 2017/07/13.
 * Rededicated by cyoste on 2017/09/17.
 */
//TODO before releasing make sure all your classes have the right access modifiers.
//I might make a bunch of them public for testing purposes.'

/**
 * For now, I'm assuming that we only have the type of int.
 * The real spec calls for three different types.
 */

/**
 * IF YOU'RE GOING TO USE A HASHMAP, THE KEYS MUST BE IMMUTABLE
 * ie the index can't change.
 */

public class Table {

    private String title;
    private String[] names;
    private HashMap<Integer, Row> column = new HashMap<>();

    public Table(String t, String[] n) {
        title = t;
        names = n;
    }

    public void addRow(int[] rowElements) {
        Row addMe = new Row(rowElements);
        column.put(column.size(), addMe);
    }

    public Row getRow(int index) {
        return column.get(index);
    }
}
