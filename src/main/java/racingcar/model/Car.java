package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVE_NUMBER = 4;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public void decideToMove() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MIN_MOVE_NUMBER) {
            position.movePosition();
        }
    }

    public String getDisplayFormat() {
        return name.getDisplayFormat() + " : " + position.getDisplayFormat();
    }

    public Position position() {
        return this.position;
    }

    public Name name() {
        return this.name;
    }
}
