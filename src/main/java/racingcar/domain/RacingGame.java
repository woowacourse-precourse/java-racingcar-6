package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public List<String> race(List<String> carNames, int attemptCount) {

        MovingCondition movingCondition = new MovingCondition();
        int condition;
        boolean isMovingForward;
        List<String> racingProgress = new ArrayList<>();
        for(int c = 0; c < carNames.size(); c++){
            racingProgress.add("");
        }

        System.out.println("실행 결과");

        for (int a = 0; a < attemptCount; a++){
            for (int c = 0; c < carNames.size(); c++){

                condition = movingCondition.getRandomNumber();
                isMovingForward = movingCondition.isMovingForward(condition);
                System.out.println("condition: " + condition);
                System.out.println("isMovingForward: "+isMovingForward);

                if(isMovingForward){
                    String currentProgress = racingProgress.get(c);
                    racingProgress.set(c, currentProgress + "-");
                }
            }
            printProgressResult(carNames, racingProgress);
        }

        return racingProgress;
    }

    private void printProgressResult(List<String> carNames, List<String> racingProgress){
        for (int p = 0; p < carNames.size(); p++) {
            System.out.println(carNames.get(p) + " : " + racingProgress.get(p));
        }
        System.out.println();
    }
}
