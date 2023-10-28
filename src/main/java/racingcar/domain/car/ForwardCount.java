package racingcar.domain.car;

public class ForwardCount {

    private long forwardCount;

    private ForwardCount(long forwardCount) {
        this.forwardCount = forwardCount;
    }

    public static ForwardCount defaultOf() {
        return new ForwardCount(0L);
    }

    public void increaseByOne() {
        this.forwardCount++;
    }

    public long getCount() {
        return this.forwardCount;
    }

}
