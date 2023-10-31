package racingcar.view.statistics;

import java.util.List;
import racingcar.domain.statistics.RacingGameStatistics;

public class RacingStatisticsView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void showRacingResult(RacingGameStatistics results) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        List<String> resultMessages = results.getStatisticsMessages();
        resultMessages.forEach(System.out::println);
    }
}
