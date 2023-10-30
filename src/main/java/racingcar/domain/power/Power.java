package racingcar.domain.power;

public class Power {

    private int power;

    public Power(int power) {
        this.power = power;
    }

    public boolean isSufficientPowerToMove(Power threshold) {
        if (threshold.power <= this.power) {
            return true;
        }
        return false;
    }

}
