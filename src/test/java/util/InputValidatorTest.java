package util;

import net.bytebuddy.pool.TypePool.Resolution.NoSuchTypeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.util.InputValidatior;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    InputValidatior validatior = new InputValidatior();

    @Test
    void 자동차_이름_String_배열_중_빈_값_존재_테스트() {
        String input = "";
        String[] stringList = input.split(",");

        assertThat(validatior.hasEmptyCarName(stringList)).isTrue();
    }

    @Test
    void 자연수_검증_테스트() {
        String number = "1";

        assertThat(validatior.isNaturalNumber(number)).isTrue();
    }

    @Test
    void 자연수_예외_테스트() {
        String number = "a";

        assertThat(validatior.isNaturalNumber(number)).isFalse();
    }
}
