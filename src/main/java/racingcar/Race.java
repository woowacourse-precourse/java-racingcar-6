package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    LinkedHashMap<String, Integer> racingCars;

    Race(LinkedHashMap<String, Integer> racingCars) {
        this.racingCars = racingCars;
    }

    void racingCarInit(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            this.racingCars.put(cars[i], 0);
        }
    }

    void raceStart(int gameCount) {
        while (gameCount-- > 0) {
            for (Map.Entry<String, Integer> car : this.racingCars.entrySet()) {
                int moveCount = moveCountInit();
                String move = concatMove("-", moveCount);
                System.out.println(String.format("%s : %s", car.getKey(), move));
                car.setValue(car.getValue() + moveCount);
            }
            System.out.println();
        }
    }

    int moveCountInit() {
        return Randoms.pickNumberInRange(0, 9);
    }

    String concatMove(String move, int moveCount) {
        StringBuilder sb = new StringBuilder(move.length() * moveCount);
        for (int i = 1; i <= moveCount; i++) {
            sb.append(move);
        }
        return sb.toString();
    }
}
