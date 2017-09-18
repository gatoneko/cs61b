package db;

import java.util.HashMap;

/**
 * Created by cyoste on 2017/09/18.
 */
public class Row {

    private HashMap<Integer, Integer> row;

    public Row(int[] elements) {
        row = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            row.put(i, elements[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Row row1 = (Row) o;

        return row != null ? row.equals(row1.row) : row1.row == null;
    }

    @Override
    public int hashCode() {
        return row != null ? row.hashCode() : 0;
    }
}
