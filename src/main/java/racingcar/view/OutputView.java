package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<String> carNames, List<Integer> roundResult) {
        List<String> resultList = new ArrayList<>();
        for (int index = 0; index < carNames.size(); index++) {
            String resultString = makeResultString(index, carNames, roundResult);
            resultList.add(resultString);
        }
        String result = String.join("\n", resultList);
        System.out.println(result + '\n');
    }

    private static String makeResultString(Integer index, List<String> carNames, List<Integer> roundResult) {
        String carName = carNames.get(index);
        int distance = roundResult.get(index);
        String carMove = "-".repeat(distance);

        return carName + " : " + carMove;
    }

    public static void printGameWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

}
