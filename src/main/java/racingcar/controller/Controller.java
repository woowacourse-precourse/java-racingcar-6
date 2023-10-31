package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.CarNameValidationService;
import racingcar.service.GameService;
import racingcar.service.InputService;
import racingcar.service.RaceCountValidationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    InputService inputService = new InputService();
    GameService gameService = new GameService();
    CarNameValidationService carNameValidationService = new CarNameValidationService();
    RaceCountValidationService raceCountValidationService = new RaceCountValidationService();

    public void run() {
        initCar();
        initGame();
        gameService.playGame();
        gameService.winnerChoice();
    }

    public void initCar() {
        String carNames = inputService.inputCarNameList();
        carNameValidationService.carNameValidation(carNames);
        gameService.setCarList(carNames);
    }

    public void initGame() {
        String raceCountInString = inputService.inputRaceCount();
        raceCountValidationService.raceCountValidation(raceCountInString);
        gameService.setGame(raceCountInString);
    }

}
