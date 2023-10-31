package racingcar;

import static java.lang.Math.max;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> carList;

    public void runGame() {
        this.carList = InputManager.inputCarList();
        int tryCnt = InputManager.inputTryCnt();

        System.out.println("");
        System.out.println("실행결과");
        for(int round = 1; round <= tryCnt; round++) {
            proceedRound();
            printCarStates();
        }

        List<Car> winners = extractWinners();
        printWinners(winners);
    }

    private void printCarStates() {
        this.carList.stream()
                .forEach(System.out::println);
        System.out.println("");
    }

    private void printWinners(List<Car> winners) {
        String msg = winners.stream()
                .map(element -> element.getName())
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + msg);
    }

    private List<Car> extractWinners() {
        int farthestPosition = findFarthestPosition();
        return this.carList.stream()
                .filter(element -> element.isWinner(farthestPosition))
                .collect(Collectors.toList());
    }

    private int findFarthestPosition() {
        return this.carList.stream()
                .mapToInt(element -> element.getPosition())
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private void proceedRound() {
        this.carList.stream().forEach(element -> {
            element.move();
        });
    }
}
