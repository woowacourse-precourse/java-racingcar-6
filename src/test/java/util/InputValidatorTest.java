package util;

import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    InputValidator validator = new InputValidator();

    @Test
    void 자동차_이름_String_배열_중_빈_값_존재_테스트() {
        String input = "";
        String[] stringList = input.split(",");

        assertThat(validator.hasEmptyCarName(stringList)).isTrue();
    }

    @Test
    void 자연수_검증_테스트() {
        String number = "1";

        assertThat(validator.isNaturalNumber(number)).isTrue();
    }

    @Test
    void 자연수_예외_테스트() {
        String number = "a";

        assertThat(validator.isNaturalNumber(number)).isFalse();
    }

    @Test
    void 중복_자동차_이름_테스트() {
        String[] names = {"car1", "car1", "car2"};
        assertThat(validator.isDuplicate(names)).isTrue();
    }
}
