package racingcar.racing;

public class RoundCount {

    private final int count;

    public RoundCount(final String count) {
        RoundCountValidator.validate(count);
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }
}
