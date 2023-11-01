package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final Integer MOVING_FORWARD = 4;

    private String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void advanceOrStop() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MOVING_FORWARD) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(name)
                .append(" : ")
                .append("-".repeat(position))
                .toString();
    }
}
