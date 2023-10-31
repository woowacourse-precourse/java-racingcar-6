package racingcar.domain;

import racingcar.common.consts.SystemConst;
import racingcar.common.utils.NumberGenerator;

public class Car implements Comparable<Car> {
    private String name;
    private Integer advance;

    public Car(String name) {
        this.name = name;
        this.advance = SystemConst.INITIAL_ADVANCE;
    }

    public Car(String name, int advance) {
        this.name = name;
        this.advance = advance;
    }


    public CarDto toDto() {
        return new CarDto(this.name, this.advance);
    }

    public void move() {
        int number = NumberGenerator.makeRandomNumber();
        if (number >= SystemConst.MOVE_FORWARD_NUMBER) {
            moveForward();
        }
    }

    private void moveForward() {
        this.advance += SystemConst.ADVANCE_STEP;
    }

    @Override
    public int compareTo(Car other) {
        return other.advance.compareTo(this.advance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < this.advance; i++) {
            sb.append(SystemConst.ADVANCE_DISPLAY_CHARACTER);
        }
        return sb.toString();
    }
}
