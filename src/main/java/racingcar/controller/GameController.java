package racingcar.controller;

import racingcar.service.SaveInputValue;

import java.util.List;

public class GameController {

    static List<String> cars;
    static String repeatNumber;

    SaveInputValue saveInputValue = new SaveInputValue(cars, repeatNumber);

    public void startGame() {
        saveInputValue.saveCarName();
        saveInputValue.saveRepeatNumber();
    }
}
