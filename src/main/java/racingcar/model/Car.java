package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {


    private final int RANDOM_START_NUMBER = 0;
    private final int RANDOM_END_NUMBER = 9;
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
    }


}
