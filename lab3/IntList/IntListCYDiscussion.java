import java.util.Formatter;

/**
 * Scheme-like pairs that can be used to form a list of integers.
 *
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 *         [Do not modify this file.]
 */
public class IntListCYDiscussion {

    public static void main(String[] args){
        IntListCYDiscussion a = IntListCYDiscussion.list(5, 2, 3);
        IntListCYDiscussion b = IntListCYDiscussion.iterativeSquareNonDestructiveCY(a);
        System.out.println("original: " + a);
        System.out.println("new: " + b);
    }


    public static IntListCYDiscussion recursiveSquareDestructiveCY(IntListCYDiscussion L){
        if (L == null){
            return L;
        } else {
            L.first *= L.first;
            recursiveSquareDestructiveCY(L.rest);
        }
        return L;
    }

    public static IntListCYDiscussion iterativeSquareNonDestructiveCY(IntListCYDiscussion L){
        IntListCYDiscussion X;
        X = new IntListCYDiscussion(L.first * L.first, null);
        L = L.rest;
        while (L != null){
            X = new IntListCYDiscussion(L.first * L.first, X);
            L = L.rest;
        }

        IntListCYDiscussion Y = new IntListCYDiscussion(X.first, null);
        X = X.rest;
        while (X != null){
        Y = new IntListCYDiscussion(X.first, Y);
        X = X.rest;
        }

        return Y;
    }
    /**
     * Made for discussion sheet
     * @param L
     * @return
     */
    public static IntListCYDiscussion squareDestructiveCY(IntListCYDiscussion L){
        IntListCYDiscussion B = L;
        while (B != null){
            B.first *= B.first;
            B = B.rest;
        }
        return L;
    }

    /**
     * Made for discussion sheet
     * @param L
     * @return
     */
    public static IntListCYDiscussion squareNonDestructiveCY(IntListCYDiscussion L){

        if (L == null){
            return L;
        } else {
            IntListCYDiscussion A = squareNonDestructiveCY(L.rest);
            IntListCYDiscussion B = new IntListCYDiscussion(L.first * L.first, A);
            return B;
        }


    }
    /**
     * First element of list.
     */
    public int first;
    /**
     * Remaining elements of list.
     */
    public IntListCYDiscussion rest;

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public IntListCYDiscussion(int first0, IntListCYDiscussion rest0) {
        first = first0;
        rest = rest0;
    }

    /**
     * A List with null rest, and first = 0.
     */
    public IntListCYDiscussion() {
    /* NOTE: public IntList () { }  would also work. */
        this(0, null);
    }

    /**
     * Returns a list equal to L with all elements squared. Destructive.
     */
    public static void dSquareList(IntListCYDiscussion L) {

        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntListCYDiscussion squareListIterative(IntListCYDiscussion L) {
        if (L == null) {
            return null;
        }
        IntListCYDiscussion res = new IntListCYDiscussion(L.first * L.first, null);
        IntListCYDiscussion ptr = res;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntListCYDiscussion(L.first * L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return res;
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntListCYDiscussion squareListRecursive(IntListCYDiscussion L) {
        if (L == null) {
            return null;
        }
        return new IntListCYDiscussion(L.first * L.first, squareListRecursive(L.rest));
    }

    /** DO NOT MODIFY ANYTHING ABOVE THIS LINE! */


    /**
     * Returns a list consisting of the elements of A followed by the
     * *  elements of B.  May modify items of A. Don't use 'new'.
     */

    public static IntListCYDiscussion dcatenate(IntListCYDiscussion A, IntListCYDiscussion B) {
        //TODO:  fill in method
        return null;
    }

    /**
     * Returns a list consisting of the elements of A followed by the
     * * elements of B.  May NOT modify items of A.  Use 'new'.
     */
    public static IntListCYDiscussion catenate(IntListCYDiscussion A, IntListCYDiscussion B) {
        //TODO:  fill in method
        return null;
    }


    /**
     * DO NOT MODIFY ANYTHING BELOW THIS LINE! Many of the concepts below here
     * will be introduced later in the course or feature some form of advanced
     * trickery which we implemented to help make your life a little easier for
     * the lab.
     */

    @Override
    public int hashCode() {
        return first;
    }

    /**
     * Returns a new IntList containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static IntListCYDiscussion list(Integer... args) {
        IntListCYDiscussion result, p;

        if (args.length > 0) {
            result = new IntListCYDiscussion(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntListCYDiscussion(args[k], null);
        }
        return result;
    }

    /**
     * Returns true iff X is an IntList containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof IntListCYDiscussion)) {
            return false;
        }
        IntListCYDiscussion L = (IntListCYDiscussion) x;
        IntListCYDiscussion p;

        for (p = this; p != null && L != null; p = p.rest, L = L.rest) {
            if (p.first != L.first) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     * <p>
     * If there is no cycle, the number 0 is returned instead. This is a
     * utility method for lab2. You are not expected to read, understand, or
     * even use this method. The point of this method is so that if you convert
     * an IntList into a String and that IntList has a loop, your computer
     * don't get stuck in an infinite loop.
     */

    private int detectCycles(IntListCYDiscussion A) {
        IntListCYDiscussion tortoise = A;
        IntListCYDiscussion hare = A;

        if (A == null)
            return 0;

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.rest != null)
                hare = hare.rest.rest;
            else
                return 0;

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null)
                return 0;

            if (hare == tortoise)
                return cnt;
        }
    }

    @Override
    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (IntListCYDiscussion p = this; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }
}

