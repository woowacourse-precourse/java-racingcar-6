package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameWinner {
    static final String FINAL_WINNER = "최종 우승자";
    public static void printFinalWinner(Map<String, Integer> carInfo) {

        int max = 0;
        for (String name : carInfo.keySet()) {
            if (carInfo.get(name) >= max) {
                max = carInfo.get(name);
            }
        }

        List<String> winner = new ArrayList<>();
        for (String name : carInfo.keySet()) {
            if (carInfo.get(name) == max) {
                winner.add(name);
            }
        }
        System.out.print(FINAL_WINNER + " : " + winner.stream().collect(Collectors.joining(",")));
    }
}

