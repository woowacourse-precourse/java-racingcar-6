package racingcar;

import racingcar.model.Car;

public enum CarFixtures {
    POBY("poby"),
    WONY("wony"),
    JUN("jun"),
    HYUK("hyuk");

    private final String name;

    CarFixtures(String name) {
        this.name = name;
    }

    public Car 생성() {
        return new Car(this.name);
    }

    public Car 움직인_횟수와_생성(int count) {
        final Car car = 생성();
        while (car.getMoveCount() < count) {
            car.move();
        }
        return car;
    }

}
