package racingcar.engine;

import java.util.List;

public class GameEngineValidator {
    private static final String NULL_EXCEPTION_MESSAGE = "입력값은 null입니다.";

    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final String PLAYER_NAME_EXCEPTION_MESSAGE = "현재 입력된 플레이어 이름의 길이는 %d, %d이하로 해주세요.";

    private static final int ZERO = 0;
    private static final String NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE = "해당값은 음수입니다.";
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자로 변환 할 수 없습니다.";

    void validateIsNotNull(String readLine) {
        if (readLine == null)
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
    }

    void validatePlayerNames(List<String> playerNames) {
        for (String playerName : playerNames) {
            if (playerName.length() > PLAYER_NAME_MAX_SIZE)
                throw new IllegalArgumentException(String.format(PLAYER_NAME_EXCEPTION_MESSAGE, playerName.length(), PLAYER_NAME_MAX_SIZE));
        }
    }

    void validateIsPositiveNumber(String readLine) {
        validateIsNotNull(readLine);
        validateIsNumber(readLine);
        if (Long.parseLong(readLine) < ZERO)
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
    }

    private void validateIsNumber(String readLine) {
        try {
            Long.parseLong(readLine);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
