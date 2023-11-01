package racingcar.model;

import static racingcar.model.ConstantString.NAME_IS;
import static racingcar.model.ConstantString.UNIT_MOVE;
import static racingcar.util.ConstantNumbers.LOWER_BOUND;
import static racingcar.util.ConstantNumbers.THRESHOLD;
import static racingcar.util.ConstantNumbers.UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>, Model {
    private final String name;
    private int moved;
    private final int index;

    Car(final String name, final int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * Car 객체의 이동/정지에 따른 moved 정수 변수 값을 변경하는 메서드
     */
    public void moveOrStop() {
        if (Randoms.pickNumberInRange(LOWER_BOUND.number(), UPPER_BOUND.number()) >= THRESHOLD.number()) {
            moved++;
        }
    }

    String getName() {
        return name;
    }
    int getMoved() {
        return moved;
    }

    boolean isDraw(final Car other) {
        return this.moved == other.moved;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();

        print.append(String.format(NAME_IS.string(), name));
        print.append(UNIT_MOVE.string().repeat(moved));

        return print.toString();
    }

    @Override
    public int compareTo(final Car other) {
        if (other.moved == this.moved) {
            return this.index - other.index;
        }

        return other.moved - this.moved;
    }
}