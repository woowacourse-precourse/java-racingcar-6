package racingcar;

import racingcar.utils.NumberGenerator;
import racingcar.utils.RealNumberGenerator;

public class Car {

    private String name;
    private int moveNum;
    private NumberGenerator numberGenerator;

    public Car(String name) {
        this.name = name;
        this.moveNum = 0;
        this.numberGenerator = new RealNumberGenerator();
    }

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.moveNum = 0;
        this.numberGenerator = numberGenerator;
    }

    public int getMoveNum() {
        return moveNum;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (numberGenerator.createRandomNumber() >= 4) {
            moveNum++;
        }
    }
}
