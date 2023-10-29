package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.util.Constants;

public class Car {
    private final String name;
    private int position = 0;

    private Car(final String name) {
        this.name = name;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move() {
        int randomNumber = randomNumberGenerator();

        if (isMoreThanFour(randomNumber)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private int randomNumberGenerator() {
        return pickNumberInRange(Constants.START_INCLUSIVE, Constants.END_INCLUSIVE);
    }

    private boolean isMoreThanFour(final int pickedNumber) {
        return pickedNumber >= 4;
    }
}
