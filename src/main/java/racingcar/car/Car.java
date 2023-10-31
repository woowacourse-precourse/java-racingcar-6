package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constant;

public class Car {
    private String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void forward(int value) {
        if (value >= Constant.MINIMUM_MOVABLE_NUMBER) {
            this.position++;
        }
    }

    public int getRandomValue() {
        return Randoms.pickNumberInRange(Constant.START_RANDOM_NUMBER, Constant.END_RANDOM_NUMBER);
    }
}
