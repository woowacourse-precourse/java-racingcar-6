package racingcar.car;

import racingcar.race.Result;

public class Car {
    private String name;
    private int distance;

    public Car(){}

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward() {
        this.distance += 1;
    }

    public Result outputResult() {
        return new Result(name, distance);
    }
}
