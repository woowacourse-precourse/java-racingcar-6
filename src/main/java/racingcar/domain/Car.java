package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private StringBuilder distance;

    public Car(String name) {
        this.name = name;
        this.distance = new StringBuilder();
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }

    public void move() {
        distance.append("-");
    }

    // 랜덤 숫자가 4이상인 경우 이동!
    public boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= Standard.Four.getValue();
    }
}
