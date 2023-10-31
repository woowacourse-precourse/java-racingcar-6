package racingcar;

import java.util.*;

public class RacingResult {

    private final HashMap<String, Integer> racingMap;

    RacingResult(HashMap<String, Integer> racingMap){
        this.racingMap = racingMap;
    }

    private List<String> setRacingResult() {
        List<String> winnerList = new ArrayList<>();
        int maxNum = Collections.max(this.racingMap.values());

        for (Map.Entry<String, Integer> entry : this.racingMap.entrySet()) {
            if (entry.getValue() == maxNum) {
                winnerList.add(entry.getKey());
            }
        }

        return winnerList;
    }

    public void printRacingResult() {
        List<String> winnerList = this.setRacingResult();

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerList));
    }
}
