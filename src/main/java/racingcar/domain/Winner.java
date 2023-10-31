package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {
    public static void findWinners(List<String> carList, int[] goCount) {
        findMaxNumberAndToSaveIndexOfMaxNumber(goCount, carList);
    }

    public static void findMaxNumberAndToSaveIndexOfMaxNumber(int[] goCount, List<String> carList) {
        int[] copyGoCount = Arrays.copyOf(goCount, goCount.length);
        Arrays.sort(goCount);
        int maxNumber = goCount[goCount.length - 1];
        List<Integer> indexOfMaxNumber = new ArrayList<>();

        for (int i = 0; i < copyGoCount.length; i++) {
            if (copyGoCount[i] == maxNumber) {
                indexOfMaxNumber.add(i);
            }
        }
        findWinnerCarByIndexOfMaxNumber(indexOfMaxNumber, carList);
    }

    public static void findWinnerCarByIndexOfMaxNumber(List<Integer> indexOfMaxNumber, List<String> carList) {
        List<String> winner = new ArrayList<>();

        for (int index : indexOfMaxNumber) {
            winner.add(carList.get(index));
        }
        printWinner(winner);
    }

    public static void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));

            if (i < winner.size() - 1) {
                System.out.print(",");
            }
        }
    }
}