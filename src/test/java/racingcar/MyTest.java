package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.utils.Validation;

public class MyTest {
    @Test
    void isValidName1() {
        String name1 = "a333b";
        Validation.validateName(name1);
    }

    @Test
    void isValidName2() {
        String name2 = "a@ ()";
        assertThatThrownBy(() -> Validation.validateName(name2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidName3() {
        String name3 = "abcdef";
        assertThatThrownBy(() -> Validation.validateName(name3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
