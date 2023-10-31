package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;

public class Validation {
    public static boolean randomMoreFour() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public static List<Integer> racingResult(List<String> carName, List<Integer> raceResult) {
        for (int i = 0; i < carName.size(); i++) {
            if (randomMoreFour()) {
                raceResult.set(i, raceResult.get(i) + 1);
            }
        }
        return raceResult;
    }

    public static List<String> racingWinner(List<String> carName, List<Integer> raceResult) {
        int WinnerResult = Collections.max(raceResult);
        List<String> loser = new ArrayList<>();
        for (int i = 0; i < carName.size(); i++) {
            if (raceResult.get(i) < WinnerResult) {
                loser.add(carName.get(i));
            }
        }
        carName.removeAll(loser);
        return carName;
    }
}
