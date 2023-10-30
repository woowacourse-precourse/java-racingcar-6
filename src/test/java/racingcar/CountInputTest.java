package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CountInputTest {

    @Test
    void 음수_또는_0_입력_시_예외_처리(){

        // given
        String userInputOne = "-1";
        String userInputTwo = "0";

        // then
        assertThatThrownBy(()-> Validator.checkPositiveNumber(userInputOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자를 입력하세요.");

        assertThatThrownBy(()-> Validator.checkPositiveNumber(userInputTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자를 입력하세요.");
    }

    @Test
    void 문자_또는_공백_입력_시_예외_처리(){

        // given
        String userInputOne = "3pobi";
        String userInputTwo = " ";

        // then
        assertThatThrownBy(()-> Validator.checkPositiveNumber(userInputOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력하세요.");

        assertThatThrownBy(()-> Validator.checkPositiveNumber(userInputTwo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력하세요.");
    }



}
