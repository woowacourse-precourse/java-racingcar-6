package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void progress(List<String> carNames, int attemptCount) {

        MovingCondition movingCondition = new MovingCondition();

        List<String> racingProgress = new ArrayList<>();
        for(int c = 0; c < carNames.size(); c++){
            racingProgress.add("");
        }

        for (int a = 0; a < attemptCount; a++){
            for (int c = 0; c < carNames.size(); c++){
                boolean condition = movingCondition.isMoveForward();
                if(condition){
                    String currentProgress = racingProgress.get(c);
                    racingProgress.set(c, currentProgress + "-");
                }
            }
        }
    }
}
