package racingcar;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;
import racingcar.input.Input;
import racingcar.input.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void validLengthTest() {
        String input = "pobiii,woni,jun";
        String[] result = input.split(",");

        assertThatThrownBy(() -> InputValidator.isValidCarName(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validRoundInputTest() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        assertThat(3).isEqualTo(Input.getRound());
    }

    @Test
    void validTypeTest() {
        assertThatThrownBy(() -> InputValidator.isValidRound("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validRangeTest() {
        assertThatThrownBy(() -> InputValidator.isValidRound("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}