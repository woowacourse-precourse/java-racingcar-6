package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.ConsoleInput;

public class Game {

    private List<Car> users;

    private int attemptsNumber;
    public void start() {
        init();
        progress();
        end();
    }

    private void init() {
        this.users = ConsoleInput.carNamesInput();
        this.attemptsNumber = ConsoleInput.attemptsNumberInput();
    }

    private void progress() {

    }

    private void end() {

    }
}
