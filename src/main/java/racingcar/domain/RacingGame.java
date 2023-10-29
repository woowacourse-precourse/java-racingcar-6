package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public List<String> progress(List<String> carNames, int attemptCount) {

        MovingCondition movingCondition = new MovingCondition();
        List<String> racingProgress = new ArrayList<>();
        for(int c = 0; c < carNames.size(); c++){
            racingProgress.add("");
        }

        System.out.println("실행 결과");

        for (int a = 0; a < attemptCount; a++){
            for (int c = 0; c < carNames.size(); c++){
                boolean condition = movingCondition.isMoveForward();
                if(condition){
                    String currentProgress = racingProgress.get(c);
                    racingProgress.set(c, currentProgress + "-");
                }
            }
            progressResult(carNames, racingProgress);
        }

        return racingProgress;
    }

    public void progressResult(List<String> carNames, List<String> racingProgress){
        for (int p = 0; p < carNames.size(); p++) {
            System.out.println(carNames.get(p) + " : " + racingProgress.get(p));
        }
        System.out.println();
    }
}
