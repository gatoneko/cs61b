package db;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cyoste on 2017/07/13.
 */
//TODO before releasing make sure all your classes have the right access modifiers.
//I might make a bunch of them public for testing purposes.
public class Table {

    private class Column <T> {
        ArrayList <T> columnItems;
        public <T> Column() {
            columnItems = new ArrayList<>();
        }

        public void add(T dataPoint) {
            columnItems.add(dataPoint);
        }
    }

    private String tableTitle;
    private HashMap <Integer, String> columnNames; //index, value
    private ArrayList <Column> columns;

    public Table(String title, String[] names) {
        tableTitle = title;
        columnNames = new HashMap<>();
        columns = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            columnNames.put(i, names[i]);
            columns.add(new Column<Integer>());
        }
    }

    public void addRow (int[] rowData) {
        for (int i = 0; i < rowData.length; i++) {
            columns.get(i).add(rowData[i]);
        }
    }

    public static Table join(Table t1, Table t2) {

        Table result = joinColumnNames(t1, t2);
        return result;
    }

    public static Table joinColumnNames(Table t1, Table t2){
        HashMap<Integer, String> newColumnHash = new HashMap<>();

        HashMap<Integer, String> t1ColumnNames = t1.getColumnNamesHashMap();
        HashMap<Integer, String> t2ColumnNames = t2.getColumnNamesHashMap();

        //Put the shared keys in the list first.
        for (int i = 0; i < t1ColumnNames.size(); i++) {
            String valuet1 = t1ColumnNames.get(i);
            if (t2ColumnNames.containsValue(valuet1)) {
                newColumnHash.put(newColumnHash.size(), valuet1);
            }
        }
        //Put the unshared t1 keys in the list 2nd
        for (int i = 0; i < t1ColumnNames.size(); i++) {
            String valuet1 = t1ColumnNames.get(i);
            if (!newColumnHash.containsValue(valuet1)) {
                newColumnHash.put(newColumnHash.size(), valuet1);
            }
        }
        //Put the unshared t2 keys in the list 3rd
        for (int i = 0; i < t2ColumnNames.size(); i++) {
            String valuet2 = t2ColumnNames.get(i);
            if (!newColumnHash.containsValue(valuet2)) {
                newColumnHash.put(newColumnHash.size(), valuet2);
            }
        }
        // build string array
        String[] newColumnNames = new String[newColumnHash.size()];
        for (int i = 0; i < newColumnHash.size(); i++) {
            newColumnNames[i] = newColumnHash.get(i);
        }
        Table result = new Table( "result", newColumnNames);
        return result;
    }

    public ArrayList<String> getColumnNames() {
        return new ArrayList<>((columnNames.values()));
    }

    public HashMap<Integer, String> getColumnNamesHashMap() {
        return columnNames;
    }

}
