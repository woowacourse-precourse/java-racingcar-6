package racingcar;

import java.util.List;
import java.util.Random;

public class GameLogic {
    private int maxPosition = 0;

    public void runGame(List<String> carNames, int raceRounds) {
        System.out.println("실행 결과");
        for (int i = 0; i < raceRounds; i++) {
            for (String carName : carNames) {
                String progress = generateProgress();
                System.out.println(carName + " : " + progress);
            }
            System.out.println();
        }
    }
}
