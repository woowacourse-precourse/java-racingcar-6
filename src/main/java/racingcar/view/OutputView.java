package racingcar.view;

import racingcar.model.Race;

import java.util.List;

public class OutputView {
    public static void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(Race race) {
        List<String> carNames = race.getCarNames();
        List<Integer> roundResult = race.getRoundResult();

        String result = buildResultString(carNames, roundResult);

        System.out.println(result);
    }

    private static String buildResultString(List<String> carNames, List<Integer> roundResult) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < carNames.size(); index++) {
            int distance = roundResult.get(index);
            stringBuilder.append(carNames.get(index));
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(distance));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public static void printGameWinners(Race race) {
        List<String> winners = race.getWinners();
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

}
