package racingcar.dto;

import racingcar.view.constants.ConstantMessage;

import java.util.List;

public record FinalResponse(
        List<String> winnerNames
) {
    private static final String DELIMITER = ", ";

    public String toResponse() {
        String dividedNames = String.join(DELIMITER, winnerNames);
        return String.format(ConstantMessage.FINAL_WINNER_MESSAGE.getMessage(), dividedNames);
    }
}
