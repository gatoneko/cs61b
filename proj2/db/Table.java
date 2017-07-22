package db;

import java.util.ArrayList;

/**
 * Created by cyoste on 2017/07/13.
 */
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

    private String tableName;
    private ArrayList <String> columnNames;
    private ArrayList <Column> columns;

    public Table(String title, String[] names) {
        tableName = title;
        for (String name : names) {
            columnNames.add(name);
            columns.add(new Column<Integer>());
        }
    }

    public void addRow (ArrayList <Integer> rowData) {
        for (int i = 0; i < rowData.size(); i++) {
            columns.get(i).add(rowData.get(i));
        }
    }

}
