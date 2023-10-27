package racingcar.controller;

import racingcar.domain.Car;
import racingcar.exception.CountException;
import racingcar.exception.NameException;
import racingcar.view.PlayerInput;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Car> carList = new ArrayList<>();
    private final PlayerInput input = new PlayerInput();
    private Integer tryCount;

    public void start() {
        String nameInput = input.inputCarNames();
        String[] names = nameInput.split(",");

        NameException.validation(names);

        String number = input.inputTryCount();

        CountException.validation(number);
        gameInit(names, number);
    }

    private void gameInit(String[] names, String number) {
        for (String name : names) {
            carList.add(new Car(name));
        }

        this.tryCount = Integer.parseInt(number);
    }
}
