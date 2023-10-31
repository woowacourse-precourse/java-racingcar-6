package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.GeneratedRandomNumber;

public class GeneratedRandomNumberTest {

    private final int START_RANGE = 0;
    private final int END_RANGE = 9;

    @Test
    @DisplayName("0-9 사이의 숫자가 반환된다.")
    void generatedRandomNumberTest() throws Exception {
        assertThat(GeneratedRandomNumber.getNumber()).isBetween(START_RANGE, END_RANGE);
    }
}
