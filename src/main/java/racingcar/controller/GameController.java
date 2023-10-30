package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.Output;
import racingcar.view.UserInput;

public class GameController {
    private static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String PRINT_RESULT_MESSAGE = "실행 결과";

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    private final UserInput userInput = new UserInput();
    private final Output output = new Output();

    private List<Car> carList;
    private int gameCount;

    public void gameStart() {
        askInputUser();
        doGame();
        output.printFinalWinner(getWinnerName(carList));
    }

    private void askInputUser() {
        output.printGameMessage(ASK_CAR_NAMES_MESSAGE);
        carList = changeUserInputToCarList(userInput.readCarNames());

        output.printGameMessage(ASK_GAME_COUNT_MESSAGE);
        gameCount = userInput.readGameCount();
    }

    private List<Car> changeUserInputToCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private void doGame() {
        output.printGameMessage(System.lineSeparator() + PRINT_RESULT_MESSAGE);

        for (int i = 0; i < gameCount; i++) {
            doStep();
            output.printCurrentCar(carList);
        }
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