package racingcar.domain;

import java.util.Map;

public class Racing {
    public Map<String, Integer> racingMoveCount() {
        RacingCount racingCount = new RacingCount();
        ForwardCar car = new ForwardCar();

        int raceCount = racingCount.inputRacingCount();
        System.out.println();
        System.out.println("실행 결과");
        Map<String, Integer> result = null;
        for (int i = 0; raceCount > i; i++) {
            result = car.racingCarCount();
            printRacingCar(result);
            System.out.println();
        }
        return result;
    }

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
