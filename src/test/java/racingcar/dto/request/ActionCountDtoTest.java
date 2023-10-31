package racingcar.dto.request;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.constants.ErrorMessage.NEGATIVE_INTEGER;
import static racingcar.constants.ErrorMessage.NOT_INTEGER;

import org.junit.jupiter.api.Test;

class ActionCountDtoTest {
    @Test
    void 시도할횟수가_정수가아닌값으로_입력되면_예외발생시키기() {
        // given
        String request = "안녕";

        // when & then
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new ActionCountDto(request);
        });
        assertEquals(NOT_INTEGER, exception.getMessage());
    }

    @Test
    void 시도할횟수가_음수로_입력되면_예외발생시키기() {
        // given
        String request = "-3";

        // when & then
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> {new ActionCountDto(request);
        });
        assertEquals(NEGATIVE_INTEGER, exception.getMessage());
    }
}