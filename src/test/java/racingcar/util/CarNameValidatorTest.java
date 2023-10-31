package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameValidatorTest {


    @Test
    void 이름_유효성_검사_null() {
        String userName = null;

        assertThatThrownBy(() -> CarNameValidator.validate(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력하지 않았습니다.");

    }

    @Test
    void 이름_유효성_검사_length() {
        String userName = "길이초과입니다";

        assertThatThrownBy(() -> CarNameValidator.validate(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5를 초과할 수 없습니다.");
    }

    @Test
    void 이름_유효성_검사_공백() {
        String userName = "  공백";

        assertThatThrownBy(() -> CarNameValidator.validate(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 공백이 존재할 수 없습니다.");
    }


    @Test
    void 중복된_이름이_존재할수_없다() {
        List<String> carNames = List.of("바보", "바보", "부부");
        assertThatThrownBy(() -> CarNameValidator.validateUniqueNameCheck(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }


}