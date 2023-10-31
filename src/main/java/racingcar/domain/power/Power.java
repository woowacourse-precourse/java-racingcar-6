package racingcar.domain.power;

public class Power {

    private final int value;

    public Power(int value) {
        this.value = value;
    }

    public boolean isSufficientToDrive(Power threshold) {
        if (threshold.value <= this.value) {
            return true;
        }
        return false;
    }

}
