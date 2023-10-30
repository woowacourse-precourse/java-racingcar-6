package racingcar.domain;

import java.util.Map;

public class PrintRacingRankStatus {
    public void printRacingCar(Map<String, Integer> result) {
        result.forEach((key, value) -> {
            System.out.print(key + " : ");
            printMoveCount(value);
            System.out.println();
        });
    }

    public void printMoveCount(int moveCount) {
        for (int i = 0; moveCount > i; i++) {
            System.out.print("-");
        }
    }
}
