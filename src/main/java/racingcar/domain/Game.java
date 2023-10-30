package racingcar.domain;

public class Game {
    Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public Cars racing() {
        cars.racing();
        return cars;
    }

}
