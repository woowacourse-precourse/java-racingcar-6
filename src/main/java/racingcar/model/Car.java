package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Validator;

public class Car {

    private String name;
    private int position;

    final static int MIN_RANDOM_NUM = 0;
    final static int MAX_RANDOM_NUM = 9;

    final static int FORWARD_CRITERIA = 4;

    public Car(String name) {
        Validator.carName(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int rand_num = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);

        if (rand_num >= FORWARD_CRITERIA) position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
