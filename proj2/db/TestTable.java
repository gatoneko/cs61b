package db;

import org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;


/**
 * Created by cyoste on 2017/07/22.
 */
public class TestTable {

    @Test
    public void testOneRowTable() {
        String tableTitle = "Test Table";
        String[] namesOfColumns = {"a", "b", "c", "d", "e"};
        int[] rowData1 = {1,2,3,4,5};
        int[] rowData2 = {6,7,8,9,0};
        int[] rowData3 = {1,2,3,4,5};

        Table table = new Table(tableTitle, namesOfColumns);
        table.addRow(rowData1);
        table.addRow(rowData2);
        table.addRow(rowData3);
    }

    @Test
    /** Tests the order of column names when joined */
    public void testJoinColumnNames() {
        String[] t1Names = {"a", "b", "c", "d", "e"};
        Table t1 = new Table("t1", t1Names);

        String[] t2Names = {"z", "y", "x", "d", "e"};
        Table t2 = new Table("t2", t2Names);

        Table t3 = Table.joinColumnNames(t1, t2);

        String[] correctNames = {"d", "e", "a", "b", "c", "z", "y", "x"};
        Table tAnswer = new Table ("t1", correctNames);

        ArrayList<String> t3Names = t3.getColumnNames();
        ArrayList<String> t3Answer = tAnswer.getColumnNames();

        for (int i = 0; i < t3Names.size(); i++) {
            assert(t3Names.get(i).equals(t3Answer.get(i)));
        }
    }

    @Test
    /** Tests a simple join from lab5 example 1*/
    public void testJoin() {
        String[] t1Names = {"X", "Y"};
        Table t1 = new Table("t1", t1Names);
        t1.addRow(new int[] {2, 5});
        t1.addRow(new int[] {8, 3});
        t1.addRow(new int[] {13, 7});

        String[] t2Names = {"X", "Z"};
        Table t2 = new Table("t2", t2Names);
        t2.addRow(new int[] {2, 4});
        t2.addRow(new int[] {8, 9});
        t2.addRow(new int[] {10, 1});
        t2.addRow(new int[] {11, 1});

        Table t3 = Table.join(t1, t2);

        String[] t3AnswerNames = {"X", "Y", "Z"};
        Table t3Answer = new Table("t3", t3AnswerNames);
        t2.addRow(new int[] {2, 5, 4});
        t2.addRow(new int[] {8, 3, 9});

        assert(t3Answer.equals(t3));
    }
}
