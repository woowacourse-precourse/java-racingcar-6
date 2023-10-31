package racingcar.util;

import static racingcar.util.constant.GameRule.MAX_NICKNAME_LENGTH;
import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_LENGTH_ERROR;
import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_SPACE_ERROR;
import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_UNIQUE_ERROR;
import static racingcar.util.messageContent.ExceptionMessageContent.NOT_INTEGER_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Censor {

    public void checkInputForNickname(String input) {
        commonValid(input);
        List<String> playerList = TypeTransducer.strToList(input);
        checkLength(playerList);
        checkUniqueValue(playerList);
    }

    public void checkInputForGameTime(String input) {
        commonValid(input);
        checkInteger(input);
    }

    private void commonValid(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NICKNAME_SPACE_ERROR.getContent());
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(NICKNAME_SPACE_ERROR.getContent());
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(NICKNAME_SPACE_ERROR.getContent());
        }

        if (input.endsWith(",")) {
            throw new IllegalArgumentException(NICKNAME_SPACE_ERROR.getContent());
        }
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

    private void checkInteger(String input) {
        boolean integerNumber = input.matches("-?\\d+");
        if (!integerNumber) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR.getContent());
        }
    }

}
