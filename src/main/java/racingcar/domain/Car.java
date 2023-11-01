package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.domain.wrapper.CarName;

public class Car {
    private final CarName name;
    private int movedDistance;
    private Car(CarName name) {
        this.name = name;
        this.movedDistance = 0;
    }
    public static Car create(String name) {
        CarName carName = CarName.create(name);
        return new Car(carName);
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    public void tryMove() {
        if (pickNumberInRange(1, 9) >= 4) {
            move();
        }
    }

    public CarName getName() {
        return name;
    }

    public String getCarInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name.getCarName());
        builder.append(" : ");
        builder.append("-".repeat(Math.max(0, this.movedDistance)));
        return builder.toString();
    }

    private void move() {
        ++this.movedDistance;
    }

}
