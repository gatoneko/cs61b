/**
 * Created by cyoste on 2017/06/25.
 */
public class OffByN implements CharacterComparator {
    int N;

    public OffByN(int number) {
        N = number;
    }

    /** returns true if chars are exactly N letters apart */
    @Override
    public boolean equalChars(char a, char b) {
        if (Math.abs(a - b) == N) {
            return true;
        }
        return false;
    }
}
