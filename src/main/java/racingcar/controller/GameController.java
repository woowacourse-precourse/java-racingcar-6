package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RaceGame;
import racingcar.view.InputView;

public class GameController {
    RaceGame raceGame = new RaceGame();
    InputView inputView = new InputView();

    public void startGame() {
        raceGame.setInputCarName(inputView.enterCarName());
        saveCarNames();
    }

    public void saveCarNames() {
        List<String> carNames = convertStringToIntList(raceGame.getInputCarName());
        System.out.println(carNames);
    }

    private List<String> convertStringToIntList(String carName) {
        List<String> carNames = new ArrayList<>();
        String[] convertStringArray = carName.split(",");

        for (String car : convertStringArray) {
            carNames.add(car);
        }
        return carNames;
    }

}
