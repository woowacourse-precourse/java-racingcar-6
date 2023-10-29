package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.UserInput;

public class MyApplicationTest {

    @Test
    void 이름_오기입_구분시_쉼표_미사용_예외처리() {
        String input = "blank blank blank";
        assertThatThrownBy(() ->
                UserInput.checkCommasInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하의 길이로 쉼표(,)를 기준으로 구분해주세요.");
    }

    @Test
    void 이름_오기입_5자리초과_예외처리() {
        String input = "woo,test,overFive1";
        assertThatThrownBy(() ->
                UserInput.checkLengthInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로 입력해주세요.");
    }

    @Test
    void 이름_오기입_중복입력_예외처리() {
        String input = "dup,test,dup";
        assertThatThrownBy(() ->
                UserInput.checkDupInputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복없이 설정해주세요.");
    }

    @Test
    void 시도횟수_오기입_숫자가_아닌값_예외처리() {
        String input = "notNumber";
        assertThatThrownBy(() ->
                UserInput.checkInputTryNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자로 입력해주세요.");
    }


}
