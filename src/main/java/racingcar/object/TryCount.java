package racingcar.object;
public class TryCount {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static TryCount createTryCount(int count){
        TryCount tryCount = new TryCount();
        tryCount.setCount(count);
        return tryCount;
    }
}
