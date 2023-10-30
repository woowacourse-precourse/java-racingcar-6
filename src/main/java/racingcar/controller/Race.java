package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.Utils.ErrorMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {

    private final List<Car> carList = new ArrayList<>();
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
        try {
            int moveCount = Integer.parseInt(userInput);
            if (moveCount < 4) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_MIN_NUMBER_FOUR.getMessage());
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }


    private void callCarNames() {
        String input = InputView.userInput();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_BLANK.getMessage());
            }
        }
        List<Car> carList = Arrays.stream(carNames)
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
            if (car.getName().length() >= 6) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_ONLY_FIVE_BELOW.getMessage());
            }
        }
        Set<String> carNames = new HashSet<>();
        for (Car car : userInput) {
            if (!carNames.add(car.getName())) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_DUPLICATION.getMessage());
            }
        }

    }





}

