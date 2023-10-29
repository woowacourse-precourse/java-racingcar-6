package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.utils.Converter;
import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void startRace() {
        RacingCars racingCars = createRacingCars(inputCarNames());
        List<Car> carList = racingCars.getCars();
        int count = getCount();
        System.out.println();
        outputView.printResultMessage();
        for (int gameCount = 0; gameCount < count; gameCount++) {
            carList = onceRace(racingCars);
            for (int carIndex = 0; carIndex < carList.size(); carIndex++) {
                outputView.printCarResult(carList.get(carIndex).getName(), carList.get(carIndex).getPosition());
            }
            System.out.println();
        }
        List<String> winners = getWinners(carList);
        outputView.printWinner(winners);
    }

    private List<Car> onceRace(RacingCars racingCars) {
        List<Car> cars = racingCars.getCars();
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            moveForwardOrStop(car, randomNumber);
        }
        return cars;
    }

    private RacingCars createRacingCars(List<String> carNames) {
        InputValidator.validateMinCars(carNames);
        InputValidator.validateCarNames(carNames);
        return new RacingCars(carNames);
    }

    private List<String> inputCarNames() {
        return Converter.convertInputToArray(inputView.readCarNames());
    }

    private int getCount() {
        return inputView.readCount();
    }

    private void moveForwardOrStop(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }

    private int generateRandomNumber() {
        return RandomNumberGenerator.generateRandomNumber();
    }

    private List<String> getWinners(List<Car> carList) {
        List<Integer> scores = new ArrayList<>();
        List<String> winners = new ArrayList<>();
        int maxScore = 0;
        for (int carIndex = 0; carIndex < carList.size(); carIndex++) {
            scores.add(carList.get(carIndex).getPosition());
        }
        for (int scoreIndex = 0; scoreIndex < scores.size(); scoreIndex++) {
            if (scores.get(scoreIndex) > maxScore) {
                maxScore = scores.get(scoreIndex);
            }
        }
        for (int scoreIndex = 0; scoreIndex < scores.size(); scoreIndex++) {
            if(scores.get(scoreIndex) == maxScore) {
                winners.add(carList.get(scoreIndex).getName());
            }
        }
        return winners;
    }
}
