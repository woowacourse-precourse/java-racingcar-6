package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final ArrayList<Car> carList = new ArrayList<>();
    private Cars cars;

    private int moveCnt;

    public void run() {
        start();
        count();
        OutputView.printResult();
        while (moveCnt > 0) {
            cars.playSingleTurn();
            carsInformation();
            StringBuilder findWinners = getFindWinners();
            moveCnt--;
            OutputView.printFindWinner(findWinners.toString());
        }


    }

    private StringBuilder getFindWinners() {
        StringBuilder findWinners;
        int currnetMaxPosition = cars.getCurrnetMaxPosition();
        List<Car> winners = cars.findWinner(currnetMaxPosition);
        findWinners = showWinner(winners);
        System.out.println();
        return findWinners;
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
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
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


}

