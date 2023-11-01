package racingcar;

import java.util.List;
import java.util.Random;

public class GameLogic {
    private final Random random = new Random();
    private int maxPosition = 0;
    private String[] progress;

    public void runGame(List<String> carNames, int raceRounds) {
        initializeProgress(carNames.size());
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceRounds; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                updateProgress(j);
                System.out.println(carNames.get(j) + " : " + progress[j]);
            }
            System.out.println();
        }
    }

    private void initializeProgress(int size) {
        progress = new String[size];
        for (int i = 0; i < size; i++) {
            progress[i] = "";
        }
    }

    private void updateProgress(int index) {
        if (random.nextInt(10) >= 4) {
            progress[index] += "-";
        }
    }
}
