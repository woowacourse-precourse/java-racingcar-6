package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameLogic {
    private List<String> progresses = new ArrayList<>();
    private int maxPosition = 0;

    public void runGame(List<String> carNames, int raceRounds) {
        initializeProgress(carNames.size());
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceRounds; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                updateProgress(j);
                System.out.println(carNames.get(j) + " : " + progresses.get(j));
            }
            System.out.println();
        }
        findWinner(carNames);
    }

    private void initializeProgress(int size) {
        for (int i = 0; i < size; i++) {
            progresses.add("");
        }
    }

    private void updateProgress(int index) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            String currentProgress = progresses.get(index);
            progresses.set(index, currentProgress + "-");
        }
    }

    private void findWinner(List<String> carNames) {
        List<String> winners = getWinners(carNames);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinners(List<String> carNames) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            int currentProgress = countProgress(progresses.get(i));
            updateWinners(winners, carNames.get(i), currentProgress);
        }
        return winners;
    }

    private void updateWinners(List<String> winners, String carName, int currentProgress) {
        if (currentProgress >= maxPosition) {
            if (currentProgress > maxPosition) {
                winners.clear();
                maxPosition = currentProgress;
            }
            winners.add(carName);
        }
    }

    private int countProgress(String progress) {
        return (int) progress.chars().filter(ch -> ch == '-').count();
    }
}
