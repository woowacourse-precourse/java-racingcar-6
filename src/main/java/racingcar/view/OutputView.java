package racingcar.view;

import java.util.List;
import racingcar.response.RaceResultResponse;

public class OutputView {

    private static final String RACE_START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";
    private static final String RACE_TRY_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RACE_RESULT_MESSAGE = "\n실행 결과";
    private static final String RACE_MESSAGE = "%s : %s\n";
    private static final String ROAD = "-";
    private static final String RACE_WINNER_MESSAGE = "\n최종 우승자 : ";

    public static void printRaceStart() {
        System.out.println(RACE_START_MESSAGE);
    }

    public static void printRaceTryCount() {
        System.out.println(RACE_TRY_COUNT_MESSAGE);
    }

    public static void printRaceResult() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void printRace(RaceResultResponse response) {
        response.getCurrentPositions().forEach((name, position) ->
            System.out.printf(RACE_MESSAGE, name, printRoad(position))
        );
        printBreak();
    }

    public static String printRoad(int position) {
        return ROAD.repeat(position);
    }

    public static void printWinners(List<String> winners) {
        StringBuilder winnersName = new StringBuilder();
        winners.forEach(winner -> winnersName.append(winner + ", "));
        winnersName.delete(winnersName.length() - 2, winnersName.length());
        System.out.println(RACE_WINNER_MESSAGE + winnersName.toString());
    }

    public static void printBreak() {
        System.out.println();
    }
}
