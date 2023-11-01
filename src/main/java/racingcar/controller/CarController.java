package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    public void playGame() {
        String userCars = promptForCarNames();
        String userCount = promptForRaceCount();
        createRacingGame(userCars, userCount);
    }

    public void createRacingGame(String userCars, String userCount) {
        RacingGame race = CarService.createRace(userCars, userCount);
        race.startGame();
    }

    private String promptForCarNames() {
        OutputView.promptForCarNames();
        return getUserInput();
    }

    private String promptForRaceCount() {
        OutputView.promptForRaceCount();
        return getUserInput();
    }

    private String getUserInput() {
        return InputView.getUserInput();
    }

}
