package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Validation;


public class ValidationTest {

    @Test
    void name_0자미만_6자이상_array입력() {
        String name = "안녕하세요반갑습니다.";
        Assertions.assertThatThrownBy(() -> Validation.validateLengthOfName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void name_숫자가_아닌_값() {
        String s = "k";
        Assertions.assertThatThrownBy(() -> Validation.isNotNumber(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }
}

