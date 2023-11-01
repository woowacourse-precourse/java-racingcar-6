package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class CarController {
    private GameService gameService;
    private InputValidator inputValidator;

    public CarController(GameService gameService, InputValidator inputValidator) {
        this.gameService = gameService;
        this.inputValidator = inputValidator;
    }

    public void run() {
        try {
            List<Car> cars = getCarNames();
            int rounds = getRoundCount();

            List<String> gameResults = gameService.playGame(cars, rounds);

            // 결과 출력
            printGameResults(gameResults);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("getCarNames 실패");

        }
    }

    private List<Car> getCarNames() {
        String carNamesInput = InputView.getCarNames();
        try {
            inputValidator.validateCarNames(carNamesInput);
            return parseCarNames(carNamesInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("getCarNames 실패");

        }
    }


    private int getRoundCount() {
        String roundInput = InputView.getRoundCount();
        inputValidator.validateRoundCount(roundInput);
        return Integer.parseInt(roundInput);
    }

    private List<Car> parseCarNames(String carNamesInput) {
        String[] carNameArray = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNameArray) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private void printGameResults(List<String> gameResults) {
        for (String result : gameResults) {
            System.out.println(result);
        }
    }
}
