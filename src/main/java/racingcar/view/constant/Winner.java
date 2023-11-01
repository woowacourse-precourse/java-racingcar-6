package racingcar.view.constant;

import java.util.List;

public class Winner implements Messageable {

    private static final String WINNER_ANNOUNCEMENT_PREFIX = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    private final String winner;

    private Winner(List<String> winnerList) {
        winner = WINNER_ANNOUNCEMENT_PREFIX + String.join(DELIMITER, winnerList);
    }

    public static Winner announcement(List<String> winnerList) {
        return new Winner(winnerList);
    }

    @Override
    public String getMessage() {
        return winner;
    }
}
