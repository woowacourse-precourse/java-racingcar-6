package racingcar.dto.request;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constants.Condition.NAME_SIZE;
import static racingcar.constants.ErrorMessage.LENGTH_LIMIT;

import org.junit.jupiter.api.Test;

class CarNamesDtoTest {
    @Test
    void 경주차이름의_길이제한을_넘길때_예외발생시키기() {
        // given
        String request = "jongmee,meoru,gari";

        // when & then
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarNamesDto(request);
        });
        assertEquals(LENGTH_LIMIT + NAME_SIZE, exception.getMessage());
    }
}