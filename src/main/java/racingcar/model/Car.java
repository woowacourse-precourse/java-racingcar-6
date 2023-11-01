package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.Constants.*;


public class Car {

    private int place = SET_PLACE;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPlace() {
        return place;
    }

    public void forward() {
        if (generateRandomNumber() > MAX_CANNOT_FORWARD_NUM) {
            place++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}
