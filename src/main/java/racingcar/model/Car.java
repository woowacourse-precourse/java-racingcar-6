package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static Integer SET_PLACE = 0;
    private final static Integer MIN_RANDOM_NUM = 0;
    private final static Integer MAX_RANDOM_NUM = 9;
    private final static Integer AVAILABLE_FOWARD_NUM = 3;
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
        if (generateRandomNumber() > AVAILABLE_FOWARD_NUM) {
            place++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}
