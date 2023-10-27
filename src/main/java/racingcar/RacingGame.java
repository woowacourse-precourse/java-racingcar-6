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

    }

    private void printCarStates() {
        this.carList.stream()
                .forEach(System.out::println);
        System.out.println("");
    }

    private void proceedRound() {
        this.carList.stream().forEach(element -> {
            element.move();
        });
    }
}
