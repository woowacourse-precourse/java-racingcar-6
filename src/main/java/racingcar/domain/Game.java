package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Game {
    public void printResult(Map<String, Integer> racers) {
        CarMove carMove = new CarMove();
        for (String index : racers.keySet()) {
            if (carMove.moveOrNot()) {//저장된 key값 확인
                int result = racers.get(index) + 1;
                racers.put(index, result);
            }
            System.out.print(index + " : ");
            for (int a = 0; a < racers.get(index); a++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int topScore(Map<String, Integer> racers) {
        List<Integer> maxRacerValue = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : racers.entrySet()) {
            maxRacerValue.add(entry.getValue());
        }
        return Collections.max(maxRacerValue);
    }

    public List<String> printWinner(Map<String, Integer> racers) {
        List<String> maxRacerName = new ArrayList<>();
        //Set<Map.Entry<String, Integer>> entrySet = racers.entrySet();
        for (Map.Entry<String, Integer> entry : racers.entrySet()) {
            if (topScore(racers) == entry.getValue()) {
                maxRacerName.add(entry.getKey());
            }
        }
        return maxRacerName;
    }
}