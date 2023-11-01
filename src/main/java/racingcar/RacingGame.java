package racingcar;

import static racingcar.InputReader.*;
import static racingcar.MessagePrinter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<String> carNameList;
    private List<Car> cars;
    private int repetitions;

    public void run() {
        init();
        play();
    }

    public void init() {
        askCarNameList();
        carNameList = inputCarNames();
        cars = new ArrayList<>();

        for (String car : carNameList) {
            cars.add(new Car(car));
        }

        askRepetitions();
        repetitions = inputRepetitions();
    }

    public void play() {
        printResultMessage();

        for (int i = 0; i < repetitions; i++) {
            moveForward();
            printCurrentPosition(cars);
        }

        String winner = findWinner();
        printWinnerMessage(winner);
    }

    private void moveForward() {
        for (Car car : cars) {
            car.moveOrNot();
        }
    }

    private String findWinner() {
        int winnerPosition = getWinnerPosition();

        List<String> winnerList = cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return winnerListToString(winnerList);
    }


    private int getWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(-1, Integer::max);
    }


    private String winnerListToString(List<String> winnerList) {
        return String.join(", ", winnerList);
    }
}


