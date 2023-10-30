package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CountInputTest {

    @Test
    void 음수_입력_시_예외_처리(){

        // given
        String userInput = "-1";

        // when

        // then
        assertThatThrownBy(()-> Validator.checkPositiveNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자를 입력하세요.");
    }


}
