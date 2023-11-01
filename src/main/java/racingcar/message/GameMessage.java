package racingcar.message;

import racingcar.Car;
import racingcar.GameConfig;

import java.util.List;
import java.util.stream.Collectors;

public class GameMessage {
    public static final String CARNAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + GameConfig.DELIMITER + ") 기준으로 구분)";
    public static final String TRY_COUNT_INPUT = "시도할 회수는 몇회인가요?";
    public static final String GAME_RESULT = "실행 결과";
    public static final String WINNER_FORMAT = "최종 우승자 : %s";

    public static String getWinnerMessage(List<Car> winners) {
        if (winners.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_WINNER_EXISTS);
        }
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        return String.format(WINNER_FORMAT, winnerNames);
    }
}
