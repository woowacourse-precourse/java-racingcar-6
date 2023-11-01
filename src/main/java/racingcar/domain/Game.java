package racingcar.domain;

import java.util.List;

/**
 * Setting 객체로 부터 데이터를 받고 경주를 진행하는 클래스
 */
public class Game {
    private Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void racing() {
        cars.racing();
    }

    public List<Unchangeable> giveResult() {
        return cars.giveCopiedResult();
    }

    public String findWinner() {
        return cars.findWinner();
    }
}
