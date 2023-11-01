package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JudgeWinner {

    void judgeWinner(List<String> racingCar, List<Integer> score) {
        int max = Collections.max(score);
        List<String> winner = new ArrayList<>();

        for (int i = 0; i < score.size(); i++) {
            if (score.get(i) == max) {
                winner.add(racingCar.get(i));
            }
        }

        String printWinner = String.join(", ", winner);
        System.out.println("최종 우승자 : " + printWinner);
    }
}
