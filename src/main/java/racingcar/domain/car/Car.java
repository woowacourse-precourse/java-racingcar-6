package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    protected Name name;

    protected Distance distance;

    private Car() {

    }

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public void move() {
        if (getRandomNumber() >= 4) {
            distance.add(1);
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isEqualOrGreaterThan(Car otherCar) {
        return distance.isEqualOrGreaterThan(otherCar);
    }

    public boolean isCarWithMaxDistance(Car carWithMaxDistance) {
        return distance.isCarWithMaxDistance(carWithMaxDistance);
    }

    public String getMovementString() {
        return String.join(" : ", name.toString(), distance.toString());
    }

    public String getNameString() {
        return name.toString();
    }
 }