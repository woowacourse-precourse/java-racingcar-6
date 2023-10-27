package racingcar.controller;

import racingcar.domain.Car;
import racingcar.exception.NameException;
import racingcar.view.PlayerInput;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Car> carList = new ArrayList<>();
    private final PlayerInput input = new PlayerInput();
    private int tryCount;

    public void start() {
        String nameInput = input.inputCarNames();
        String[] names = nameInput.split(",");
        NameException.validation(names);
        input.inputTryCount();
    }
}
