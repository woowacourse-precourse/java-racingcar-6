package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class GameController {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    private final UserInput userInput;
    private final Output output;

    private List<Car> carList;
    private int gameCount;

    public GameController(UserInput userInput, Output output) {
        this.userInput = userInput;
        this.output = output;
    }

    public void gameStart() {
        askInputUser();
        doGameAndResultPrint();
    }

    private void askInputUser() {
        carList = changeUserInputToCarList(userInput.readCarNames());
        gameCount = userInput.readGameCount();
    }

    private List<Car> changeUserInputToCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private void doGameAndResultPrint() {
        output.printResultMessage();
        for (int i = 0; i < gameCount; i++) {
            doStep();
            output.printCurrentCar(carList);
        }
        output.printFinalWinner(getWinnerName(carList));
    }

    private void doStep() {
        carList.forEach(car -> car.runOrStop(generateRandomNumber()));
    }

    private List<String> getWinnerName(List<Car> carList) {
        int winScore = getMaxScore(carList);

        return carList.stream()
                .filter(car -> winScore == car.getCount())
                .map(Car::getCarName)
                .toList();
    }

    private int getMaxScore(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparing(Car::getCount))
                .get()
                .getCount();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}