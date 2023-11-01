package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void advanceOrStop() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            position += 1;
        }
    }
}
