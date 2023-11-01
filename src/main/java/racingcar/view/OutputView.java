package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.CarName;
import racingcar.parser.Parser;

public class OutputView {
    private static final String RUNNING_RESULT = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void noticeRunningResult() {
        System.out.println(RUNNING_RESULT);
    }

    public static void printCarStatus(Map<CarName, Integer> carResult) {
        String carStatus = Parser.parseCarMapToString(carResult);

        System.out.println(carStatus);
    }

    public static void noticeFinalWinner() {
        System.out.print(FINAL_WINNER);
    }

    public static void printWinnerNames(List<CarName> winnerList) {
        String winners = Parser.parseWinnerList(winnerList);

        System.out.print(winners);
    }
}
