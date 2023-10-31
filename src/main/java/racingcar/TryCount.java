package racingcar;

import java.util.function.IntPredicate;

class TryCount {
    private PositiveNumber count;

    private TryCount(String number) {
        this.count = PositiveNumber.fromString(number);
    }

    private TryCount(Integer number) {
        this.count = PositiveNumber.fromInteger(number);
    }

    public static TryCount fromString(String number) {
        return new TryCount(number);
    }

    public static TryCount fromInteger(Integer number) {
        return new TryCount(number);
    }

    public Integer getCount() {
        return this.count.getNumber();
    }

    public boolean isFinished() {
        return this.count.isZero();
    }

    public void consumeTry() {
        this.count.decrease();
    }
    
}