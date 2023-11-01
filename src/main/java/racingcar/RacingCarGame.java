package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static List<String> carStatus;

    public static void play(List<String> carNames, int tryCount) {
        initializeCarStatus(carNames);

        for (int i = 0; i < tryCount; i++) {
            playOneRound(carNames);
        }

        printFinalResult(carStatus, carNames);
    }

    private static void initializeCarStatus(List<String> carNames) {
        carStatus = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            carStatus.add("");
        }
    }

    private static void playOneRound(List<String> carNames) {
        printRoundResult(carNames);
    }

    private static void printRoundResult(List<String> carNames) {
        System.out.print("\n" + "회 경주 결과:");

        for (int i = 0; i < carStatus.size(); i++) {
            updateAndPrintCarStatus(i, carNames);
        }
    }

    private static void updateAndPrintCarStatus(int index, List<String> carNames) {
        updateCarStatus(index, carNames);
        System.out.println(carNames.get(index) + " : " + carStatus.get(index));
    }

    private static void updateCarStatus(int index, List<String> carNames) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carStatus.set(index, carStatus.get(index) + "-");
        } else {
            carStatus.set(index, carStatus.get(index) + " ");
        }
    }

    private static void printFinalResult(List<String> carStatus, List<String> carNames) {
        System.out.print("\n최종 우승자 : ");
        List<String> winners = findWinners(carStatus, carNames);
        System.out.println(String.join(", ", winners));
    }

    private static List<String> findWinners(List<String> carStatus, List<String> carNames) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carStatus.size(); i++) {
            int distance = carStatus.get(i).replace(" ", "").length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(carNames.get(i));
            } else if (distance == maxDistance) {
                winners.add(carNames.get(i));
            }
        }

        return winners;
    }
}
