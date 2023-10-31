package racingcar.racer;

import racingcar.validator.RacingCarValidator;

public class RacingCar extends Car implements Raceable {

    private int position;

    protected RacingCar(String name) {
        super(name);

        RacingCarValidator.validateNameLength(name);
        RacingCarValidator.validateNameFormat(name);
    }

    public static RacingCar nameOf(String name) {
        return new RacingCar(name);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void move() {
        // TODO: 2023/10/31
    }

    @Override
    public String toString() {
        return "RacingCar " + name + "{" +
                "position=" + position +
                '}';
    }
}
