/**
 * Created by cyoste on 2017/06/25.
 */
public class OffByOne implements CharacterComparator {

    /** returns true if chars are exactly one letter apart */
    @Override
    public boolean equalChars(char a, char b) {
        if (Math.abs(a - b) == 1) {
            return true;
        }
        return false;
    }
}
