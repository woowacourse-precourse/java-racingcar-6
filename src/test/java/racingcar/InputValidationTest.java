package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    private static final InputValidation iv = new InputValidation();

    @Test
    void 입력_문자열이_5자_초과시_예외처리() {

        //given
        String input = "abcdef";

        //when, then
        assertThatThrownBy(() -> iv.checkNameLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_숫자인지_확인() {

        //given
        String input = "12345";

        //when
        int num = iv.validNum(input);

        //then
        assertThat(num).isEqualTo(12345);
    }

    @Test
    void 입력값이_숫자가_아닌_경우_예외처리() {

        //given
        String input1 = ".";

        //when, then
        assertThatThrownBy(() -> iv.validNum(input1))
                .isInstanceOf(IllegalArgumentException.class);

        //given
        String input2 = "12?";

        //when, then
        assertThatThrownBy(() -> iv.validNum(input2))
                .isInstanceOf(IllegalArgumentException.class);

        //given
        String input3 = "test";

        //when, then
        assertThatThrownBy(() -> iv.validNum(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
