package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int location = 0;

    public Car(String carName) {
        name = carName;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void tryMove() {
        int randomInt = Randoms.pickNumberInRange(Constants.RANDOM_DICE_MIN, Constants.RANDOM_DICE_MAX);
        if (randomInt >= Constants.MOVE_CAR_NUM) {
            location++;
        }
    }

}
