package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void attemptMovingForward() {
        int random = Randoms.pickNumberInRange(0, 9);

        if (random < 4) {
            return;
        }
        position.increment();
    }
}
