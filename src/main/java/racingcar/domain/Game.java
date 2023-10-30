package racingcar.domain;

public class Game {
    Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void racing() {
        cars.racing();
    }

}
