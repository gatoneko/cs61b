package synthesizer;

/**
 * Created by cyoste on 2017/07/14.
 */
public abstract class AbstractBoundedQueue <T> implements BoundedQueue <T> {

    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }


}
