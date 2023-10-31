package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultOutput {
    public static final List<String> strResults = new ArrayList<>();
    private static final List<Integer> intResults = new ArrayList<>();
    public static final List<String> winners = new ArrayList<>();
    public static final List<String> racingCarNames = new ArrayList<>();

    public static void printRacingResult(String[] carNames, List<String> stringResult) {
        setStringResults(stringResult);

        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + " : " + strResults.get(i));
            racingCarNames.add(i, carNames[i]);
        }
        System.out.println();
    }

    private static void setStringResults(List<String> stringResult) {
        if (strResults.isEmpty()) {
            strResults.addAll(stringResult);
            return;
        }
        for (int i = 0; i < stringResult.size(); i++) {
            String addStrResult = strResults.get(i) + stringResult.get(i);
            strResults.set(i, addStrResult);
        }
    }

    public static void printWinner() {
        strResultToInt();
        findWinner();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    private static void strResultToInt() {
        for (String strResult : strResults) {
            intResults.add(strResult.length());
        }
    }

    private static void findWinner() {
        int maxMoveResult = Collections.max(intResults);
        for (int i = 0; i < intResults.size(); i++) {
            if (intResults.get(i) == maxMoveResult) {
                winners.add(racingCarNames.get(i));
            }
        }
    }
}
