package racingcar.dto.request;

import static racingcar.constants.ErrorMessage.NEGATIVE_INTEGER;
import static racingcar.constants.ErrorMessage.NOT_INTEGER;

public class ActionCountDto {

    private final Integer actionCount;

    public ActionCountDto(final String actionCount) {
        Integer integerCount =  convertToInteger(actionCount);
        validateRange(integerCount);

        this.actionCount = integerCount;
    }

    private Integer convertToInteger(final String actionCount) {
        try {
            return Integer.valueOf(actionCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    private void validateRange(final Integer actionCount) {
        if(actionCount < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER);
        }
    }

    public Integer getActionCount() {
        return actionCount;
    }
}
