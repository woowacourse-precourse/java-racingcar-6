package racingcar.model;

import static racingcar.util.ConstantNumbers.LOWER_BOUND;
import static racingcar.util.ConstantNumbers.THRESHOLD;
import static racingcar.util.ConstantNumbers.UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>, Model {
    private final String name;
    private int moved;
    private final int index;
    private static final String NAME_IS = "%s : ";
    private static final String CAR_MOVE = "-";

    Car(final String name, final int index) {
        this.name = name;
        this.index = index;
    }

    public void moveOrStop() {
        if (Randoms.pickNumberInRange(LOWER_BOUND.number(), UPPER_BOUND.number()) >= THRESHOLD.number()) {
            moved++;
        }
    }

    String getName() {
        return name;
    }

    boolean isDraw(final Car other) {
        return this.moved == other.moved;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(String.format(NAME_IS, name));
        print.append(CAR_MOVE.repeat(moved));

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