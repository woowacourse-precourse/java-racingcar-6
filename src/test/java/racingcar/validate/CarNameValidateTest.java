package racingcar.validate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidateTest {
    @Test
    void isCarNameLengthTest() {

        assertThatThrownBy(() -> CarNameValidate.validateCarName("12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하로만 입력해주세요.");
    }

    @Test
    void isCommaPresentTest() {

        assertThatThrownBy(() -> CarNameValidate.validateCarName("1 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 공백을 제외해주세요.");
    }
}