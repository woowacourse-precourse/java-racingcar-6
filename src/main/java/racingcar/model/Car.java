package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.utils.Constants;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private int createRandomNumber() {
        return pickNumberInRange(Constants.RANDOM_NUMBER_MINIMUM, Constants.RANDOM_NUMBER_MAXIMUM);
    }

    public void move() {
        int randomNumber = createRandomNumber();
        if (randomNumber > 4) {
            position++;
        }
    }
}
