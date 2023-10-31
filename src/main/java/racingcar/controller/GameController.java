package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RaceGame;
import racingcar.view.InputView;

public class GameController {
    RaceGame raceGame = new RaceGame();
    CarNameValidator carNameValidator = new CarNameValidator();
    CarRacingController carRacingController = new CarRacingController();
    InputView inputView = new InputView();

    public void startGame() {
        raceGame.setInputCarName(inputView.enterCarName());
        saveCarNames();
        raceGame.setRaceNumber(Integer.parseInt(inputView.enterRaceNumber()));
        carRacingController.playGame(raceGame);
        String winner = convertListToString(raceGame);
        System.out.println(winner);
    }

    public void saveCarNames() {
        List<String> carNames = convertStringToIntList(raceGame.getInputCarName());
        carNameValidator.toValidateCarName(carNames);

        raceGame.setCarNames(carNames);
    }

    private List<String> convertStringToIntList(String carName) {
        List<String> carNames = new ArrayList<>();
        String[] convertStringArray = carName.split(",");

        for (String car : convertStringArray) {
            carNames.add(car);
        }
        return carNames;
    }

    private String convertListToString(RaceGame raceGame) {
        String winner = String.join(", ", raceGame.getWinnerCarNames());

        return winner;
    }

}
