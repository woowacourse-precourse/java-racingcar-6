package racingcar.util;

import static racingcar.util.constant.GameRule.MAX_NICKNAME_LENGTH;
import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_LENGTH_ERROR;
import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_SPACE_ERROR;
import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_UNIQUE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Censor {

    private final TypeTransducer typeTransducer = new TypeTransducer();

    public void checkInputForNickname(String input) {
        List<String> playerList = typeTransducer.strToList(input);
        checkLength(playerList);
        checkUniqueValue(playerList);
        checkSpace(playerList);
        checkEmptyValue(playerList);
    }

    private void checkLength(List<String> playerList) {
        boolean over = playerList.stream()
                .anyMatch(nickname -> nickname.length() > MAX_NICKNAME_LENGTH.getValue());
        if (over) {
            throw new IllegalArgumentException(NICKNAME_LENGTH_ERROR.getContent());
        }
    }

    private void checkUniqueValue(List<String> playerList) {
        Set<String> uniqueNicknames = new HashSet<>(playerList);
        if (uniqueNicknames.size() != playerList.size()) {
            throw new IllegalArgumentException(NICKNAME_UNIQUE_ERROR.getContent());
        }
    }

    private void checkSpace(List<String> playerList) {
        boolean includeSpace = playerList.stream()
                .anyMatch(nickname -> nickname.contains(" "));
        if (includeSpace) {
            throw new IllegalArgumentException(NICKNAME_SPACE_ERROR.getContent());
        }
    }

    private void checkEmptyValue(List<String> playerList) {
        // TODO: 아무런 입력값이 없는 경우를 검증한다.
    }

}
