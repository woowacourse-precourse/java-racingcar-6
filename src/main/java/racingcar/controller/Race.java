package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.Utils.ErrorMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private Cars cars;
    private int moveCnt;
    private StringBuilder findWinners;

    public void run() {
        start();
        count();
        OutputView.printResult();
        while (moveCnt > 0) {
            cars.playSingleTurn();
            carsInformation();
            findWinners = getFindWinners();
            moveCnt--;
        }
        OutputView.printFindWinner(findWinners.toString());


    }

    private StringBuilder getFindWinners() {
        int currnetMaxPosition = cars.getCurrnetMaxPosition();
        List<Car> winners = cars.findWinner(currnetMaxPosition);
        System.out.println();
        return showWinner(winners);
    }

    private void carsInformation() {
        Map<String, Integer> currentPostion = cars.carsInformation();
        for (Entry<String, Integer> carsInformation : currentPostion.entrySet()) {
            OutputView.printCarsMove(carsInformation.getKey(), carsInformation.getValue());
        }
    }

    private void count() {
        OutputView.printAskCount();
        moveCnt = getMoveCount();
    }

    private void start() {
        OutputView.printRacingStart();
        callCarNames();
    }

    private static int getMoveCount() {
        String userInput = InputView.userInput();
        return Integer.parseInt(userInput);
    }


    private void callCarNames() {
        String input = InputView.userInput();
        String[] carNames = input.split(",");
        List<Car> carList = Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        validateUserInput(carList);
        cars = new Cars(carList);
    }

    private static StringBuilder showWinner(List<Car> currentWinner) {
        StringBuilder winnerResult = new StringBuilder();
        for (int i = 0; i < currentWinner.size(); i++) {
            winnerResult.append(currentWinner.get(i));
            if (i != currentWinner.size() - 1) {
                winnerResult.append(",");
            }
        }
        return winnerResult;
    }

    public static void validateUserInput(List<Car> userInput) {
        for (Car car : userInput) {
            if (car.getName().length() >= 5) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_ONLY_FIVE_BELOW.getMessage());
            }
        }
        Set<Car> userInputSet = new HashSet<>(userInput);
        if (userInputSet.size() == userInput.size()) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_DUPLICATION.getMessage());
        }
    }

}

