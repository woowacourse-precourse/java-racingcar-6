package racingcar.controller;

import static java.lang.Math.max;
import static racingcar.domain.RandomNumberGenerator.pickRandomNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private static final String CAR_NAME_SPLIT_REGEX = ",";
    private static final int ZERO_VALUE = 0;
    private static final int MIN_ADVANCE_COUNT = 4;
    private static final int ADVANCE_COUNT = 1;

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    private Cars cars = new Cars();

    public void run() {
        gameInitialize();
        playRacingGame(inputView.InputTryNumber());
        chooseWinner(cars.getCars());
    }

    public void gameInitialize() {
        String carNames = inputView.InputCarNames();
        List<String> carNameList = convertStringToCarList(carNames);
        cars.makeCarsFromCarList(carNameList);
    }

    public List<String> convertStringToCarList(String carNames) {
        String[] carNameList = carNames.split(CAR_NAME_SPLIT_REGEX);
        return List.of(carNameList);
    }

    public void playRacingGame(int tryNumber) {
        outputView.printPlayResultMessage();
        for (int tryCount = 0; tryCount < tryNumber; tryCount++) {
            pickEachCarRandomNumber(cars.getCars());
            printEachRoundResult(cars.getCars());
        }
    }

    public int getMaxAdvanceCount(Map<String, Car> carsMap) {
        int maxAdvanceCount = ZERO_VALUE;
        for (Car car : carsMap.values()) {
            maxAdvanceCount = max(maxAdvanceCount, car.getAdvanceCount());
        }
        return maxAdvanceCount;
    }

    public void printEachRoundResult(Map<String, Car> cars) {
        for (Car car : cars.values()) {
            outputView.printCarName(car);
            outputView.printCurrentCarPosition(car);
        }
        System.out.println();
    }

    public void pickEachCarRandomNumber(Map<String, Car> carsMap) {
        for (Car car : carsMap.values()) {
            int randomNumber = pickRandomNumber();
            judgeAdvanceOrLeft(car, randomNumber);
        }
    }

    public void judgeAdvanceOrLeft(Car car, int randomNumber) {
        if (randomNumber >= MIN_ADVANCE_COUNT) {
            int currentAdvanceCount = car.getAdvanceCount();
            car.setAdvanceCount(currentAdvanceCount + ADVANCE_COUNT);
        }
    }

    public void chooseWinner(Map<String, Car> carsMap) {
        int maxAdvanceCount = getMaxAdvanceCount(carsMap);
        List<String> winnerList = getWinnerList(carsMap, maxAdvanceCount);
        outputView.printFinalWinner(winnerList);
    }

    public List<String> getWinnerList(Map<String, Car> carsMap, int maxAdvanceCount) {
        return carsMap.values()
                .stream()
                .filter(car -> car.getAdvanceCount() == maxAdvanceCount)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
