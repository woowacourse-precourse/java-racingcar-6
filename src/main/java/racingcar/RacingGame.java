package racingcar;

import static racingcar.InputReader.*;
import static racingcar.MessagePrinter.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private List<String> carNameList;
    private List<Car> cars;
    private int repetitions;


    public void play() {
        askCarNameList();
        carNameList = inputCarNames();
        cars = new ArrayList<>();
        for (String car : carNameList) {
            cars.add(new Car(car));
        }
        askRepetitions();
        repetitions = inputRepetitions();

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

        ArrayList<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (winnerPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return winnerListToString(winnerList);
    }

    private int getWinnerPosition() {
        int winnerPosition = -1;
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }

        return winnerPosition;
    }

    private String winnerListToString(List<String> winnerList) {
        return String.join(", ", winnerList);
    }
}


