package racingcar.car;

import racingcar.constant.OutputMessage;

public class RacingCar extends Car {

    public RacingCar(String name) {
        super(name);
    }

    @Override
    public void moveCar(int number) {
        if(number >= 4)
            distanceDriver += OutputMessage.DISTANCE_DRIVER.getMessage();
    }
}
