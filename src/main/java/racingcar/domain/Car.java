package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.wrapper.CarDistance;
import racingcar.domain.wrapper.CarName;

public class Car {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVE_NUMBER = 4;
    private final CarName name;
    private final CarDistance movedDistance;
    private Car(String name) {
        this.name = CarName.create(name);
        this.movedDistance = CarDistance.create();
    }
    public static Car create(String name) {
        return new Car(name);
    }

    public int getMovedDistance() {
        return movedDistance.getCarDistance();
    }

    public void tryMove() {
        if (pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MIN_MOVE_NUMBER) {
            moveForward();
        }
    }

    public String getName() {
        return name.getCarName();
    }

    public String getCarInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name.getCarName());
        builder.append(" : ");
        builder.append("-".repeat(Math.max(0, getMovedDistance())));
        return builder.toString();
    }

    private void moveForward() {
        movedDistance.increment();
    }

}
