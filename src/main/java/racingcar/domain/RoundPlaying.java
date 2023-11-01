package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;

public class RoundPlaying {
    LinkedHashMap<String, Integer> playRound(LinkedHashMap<String, Integer> cars) {
        for (String name : cars.keySet()) {
            int number = createRandomNumber();
            int replaceNumber = cars.get(name);
            replaceNumber += getRoundScore(number);
            cars.replace(name, replaceNumber);
        }
        findRoundResult(cars);
        return cars;
    }

    private void findRoundResult(LinkedHashMap<String, Integer> cars) {
        for (String key : cars.keySet()) {
            printScore(key, cars);
        }
    }

    private void printScore(String key, LinkedHashMap<String, Integer> cars) {
        int score = cars.get(key);
        System.out.print(key + " : ");
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int getRoundScore(int number) {
        if (decideToMove(number)) {
            return 1;
        }
        return 0;
    }

    boolean decideToMove (int randomNumber) {
        return randomNumber >= 4;
    } // randomNumber 가 4 이상이면 true 반환

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
