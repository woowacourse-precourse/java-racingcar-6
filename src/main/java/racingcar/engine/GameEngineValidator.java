package racingcar.engine;

import java.util.List;

public class GameEngineValidator {
    private static final String NULL_EXCEPTION_MESSAGE = "입력값은 null입니다.";

    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final String PLAYER_NAME_EXCEPTION_MESSAGE = "현재 입력된 플레이어 이름의 길이는 %d, %d이하로 해주세요.";

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
}
