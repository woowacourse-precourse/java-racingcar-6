package racingcar.domain.car;

public class ForwardCount {

    private long forwardCount;

    private ForwardCount(long forwardCount) {
        this.forwardCount = forwardCount;
    }

    public static ForwardCount defaultOf() {
        return new ForwardCount(0L);
    }

    public static ForwardCount from(long count) {
        return new ForwardCount(count);
    }

    public void increaseByOne() {
        this.forwardCount++;
    }

    public long getCount() {
        return this.forwardCount;
    }

    public boolean matchesCount(long count) {
        return this.forwardCount == count;
    }

}
