package racingcar.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountRequestDtoTest {

    @Test
    void validateNumberFormatTest() {
        Assertions.assertThatThrownBy(() -> new CountRequestDto().setCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
