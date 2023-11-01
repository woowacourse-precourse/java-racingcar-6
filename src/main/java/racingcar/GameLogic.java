package racingcar;

import java.util.List;
import java.util.Random;

public class GameLogic {
    private final Random random = new Random();
    private int maxPosition = 0;

    public void runGame(List<String> carNames, int raceRounds) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < raceRounds; i++) {
            for (String carName : carNames) {
                String progress = generateProgress();
                System.out.println(carName + " : " + progress);
            }
            System.out.println();
        }
    }

    private String generateProgress() {
        if (random.nextInt(10) >= 4) {
            return "-";
        }
        return "";
    }
}
