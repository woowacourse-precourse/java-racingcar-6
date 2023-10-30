package racingcar.module.domain;

import java.util.List;

public class Game {

    private final int play;
    private final List<Car> cars;
    private int playNum;

    private Game(List<Car> cars, int play) {
        this.play = play;
        this.cars = cars;
    }
}