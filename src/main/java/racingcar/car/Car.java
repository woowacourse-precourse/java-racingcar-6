package racingcar.car;

import static racingcar.system.SystemConstant.POSITION_EXPRESSION;
import static racingcar.system.SystemConstant.WAIT_LINE_POSITION;
import static racingcar.system.SystemConstant.WIN_NUMBER_AT_LEAST;

import racingcar.assist.RandomNumberGenerator;

public class Car {

    private final String carName;
    private String position;

    Car(String carName) {
        this.carName = carName;
        this.position = WAIT_LINE_POSITION;
    }

    public void goForward() {
        if (RandomNumberGenerator.generateRandomIntNumberInRange() >= WIN_NUMBER_AT_LEAST){
            position += POSITION_EXPRESSION;
        }
    }

    @Override
    public String toString(){
        return carName;
    }

    public String getPosition(){
        return position;
    }
}
