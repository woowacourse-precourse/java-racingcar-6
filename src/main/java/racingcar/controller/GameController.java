package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarListService;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class GameController {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    private final UserInput userInput;
    private final Output output;
    private final CarListService carListService;

    private List<Car> carList;
    private int gameCount;

    public GameController(UserInput userInput, Output output, CarListService carListService) {
        this.userInput = userInput;
        this.output = output;
        this.carListService = carListService;
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
            doGameOneTime();
            output.printCurrentCar(carList);
        }
        output.printFinalWinner(carListService.getWinnerName(carList));
    }

    private void doGameOneTime() {
        carList.forEach(car -> car.runOrStop(generateRandomNumber()));
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}