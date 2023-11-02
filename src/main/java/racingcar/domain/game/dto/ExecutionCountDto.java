package racingcar.domain.game.dto;

import static racingcar.global.exception.ExceptionMessage.NUMBER_CANNOT_BE_NULL;
import static racingcar.global.exception.ExceptionMessage.NUMBER_MUST_BE_POSITIVE;

public record ExecutionCountDto(Integer number) {
    public ExecutionCountDto {
        if(number == null) {
            throw new IllegalArgumentException(NUMBER_CANNOT_BE_NULL.getMessage());
        }
        validateNumberIsPositive(number);
    }

    private void validateNumberIsPositive(Integer number) {
        if(number < 0) {
            throw new IllegalArgumentException(NUMBER_MUST_BE_POSITIVE.getMessage());
        }
    }

}
