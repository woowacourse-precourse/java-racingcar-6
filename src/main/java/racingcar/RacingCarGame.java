package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static void increaseDistanceByRandom(List<Integer> distance, int index) {
        int randoms = Randoms.pickNumberInRange(0, 9);
        if (randoms >= 4) {
            int currentDistance = distance.get(index);
            int newDistance = currentDistance + 1;
            distance.set(index, newDistance);
        }
    }

    public static void play(List<String> carNames, int tries) {
        List<Integer> distance = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            distance.add(0);
        }
        for (int i = 0; i < tries; i++) {

            for (int j = 0; j < carNames.size(); j++) {
                increaseDistanceByRandom(distance, j);
            }
            showRoundResults(carNames, distance);
        }

        List<Integer> resultIndex = compareResults(distance);
        if (resultIndex.size() == 1) {
            showSoloWinner(carNames.get(resultIndex.get(0)));
        } else {
            showMultipleWinners(carNames, resultIndex);
        }
    }

    public static List<Integer> compareResults(List<Integer> distance) {
        int maxDistance = Integer.MIN_VALUE;
        List<Integer> maxIndex = new ArrayList<>();

        for (int i = 0; i < distance.size(); i++) {
            int currentDistance = distance.get(i);
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                maxIndex.clear();
                maxIndex.add(i);
            } else if (currentDistance == maxDistance) {
                maxIndex.add(i);
            }
        }

        return maxIndex;
    }


    public static void showRoundResults(List<String> carNames, List<Integer> distance) {

        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + generateHyphens(distance.get(i)));
        }
        System.out.println();
    }

    public static String generateHyphens(int distance) {
        String hyphens = "";
        for (int i = 0; i < distance; i++) {
            hyphens = hyphens + "-";
        }
        return hyphens;
    }

    public static void showSoloWinner(String carName) {
        System.out.println("최종 우승자 : " + carName);
    }

    public static void showMultipleWinners(List<String> carNames, List<Integer> resultIndex) {
        List<String> resultWinners = new ArrayList<>();

        for (int i = 0; i < resultIndex.size(); i++) {
            resultWinners.add(carNames.get(resultIndex.get(i)));
        }
        String result = "최종 우승자 : " + String.join(", ", resultWinners);

        System.out.println(result);
    }
}

