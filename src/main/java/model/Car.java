package model;

import static message.Constants.INIT_POSITION;
import static message.Constants.MOVE_CONDITION;
import static message.Constants.RANDOM_NUMBER_MAX;
import static message.Constants.RANDOM_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (createRandomNumber() >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }


}
