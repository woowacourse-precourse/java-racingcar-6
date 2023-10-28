package racingcar.dto;

import racingcar.view.constants.Message;

import java.util.List;

public record FinalResponse(
        List<String> winnerNames
) {
    private static final String DELIMITER = ", ";

    public String toEntity() {
        String dividedNames = String.join(DELIMITER, winnerNames);
        return String.format(Message.RESPONSE_WINNER_MESSAGE.getMessage(), dividedNames);
    }
}
