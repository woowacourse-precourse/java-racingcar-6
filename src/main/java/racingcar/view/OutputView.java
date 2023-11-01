package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<String> carNames, List<Integer> roundResult) {
        String resultString = buildResultString(carNames, roundResult);
        System.out.println(resultString);
    }

    public static String buildResultString(List<String> carNames, List<Integer> roundResult) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < carNames.size(); index++) {
            String carName = carNames.get(index);
            int distance = roundResult.get(index);

            String carString = makeResultString(carName, distance);
            builder.append(carString);
        }

        return builder.toString();
    }

    public static String makeResultString(String carName, int distance) {
        String carMove = "-".repeat(distance);
        return carName + " : " + carMove + "\n";
    }

    public static void printGameWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

}
