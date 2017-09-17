import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cyoste on 2017/06/02.
 */
public class FlikTest {
    @Test
    public void testSameNumber(){
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j){
            assertEquals(i, j);
        }
    }

    @Test
    public void testFilkEquals(){
//        int i = 129;
//        for (int j = 129; i < 500; ++i, ++j){
//            assert(Flik.isSameNumber(i, j));
//        }
        assert(Flik.isSameNumber(256,256));
    }
}
