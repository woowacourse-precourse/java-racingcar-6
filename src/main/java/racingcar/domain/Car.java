package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private Integer movedDistance;
    private Car(String name) {
        this.name = name;
        this.movedDistance = 0;
    }
    public static Car create(String name) {
        validateCarName(name);
        return new Car(name);
    }


    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void tryMove() {
        if (pickNumberInRange(1, 9) >= 4) {
            move();
        }
    }

    private void move() {
        ++this.movedDistance;
    }
}
