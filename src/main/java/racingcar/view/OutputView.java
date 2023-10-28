package racingcar.view;

import java.util.List;
import racingcar.config.GameConfig;

public class OutputView {

    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    public static void printWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE_PREFIX
                + String.join(GameConfig.CAR_NAME_DELIMITER + " ", winners)
        );
    }
}
