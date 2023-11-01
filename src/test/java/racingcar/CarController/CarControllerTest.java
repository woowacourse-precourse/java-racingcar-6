package racingcar.CarController;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.InputException.*;

class CarControllerTest {

    @Test
    void splitTest() {
        String input = "abcdefghijklmno";
        String[] carNames = input.split(",");
        assertThat(carNames).contains("abcdefghijklmno");
    }

    @Test
    void carNamesInputSplitTest() {
        String input = "abc,def,ghi,jkl,mno";
        String[] carNames = input.split(",");
        assertThat(carNames[0]).isEqualTo("abc");
        assertThat(carNames[2]).isEqualTo("ghi");
        assertThat(carNames[4]).isEqualTo("mno");
    }

    @Test
    void carNamesInputOverFiveValidateTest() {
        String input = "abc111,def,ghi,jkl,mno";
        String[] carNames = input.split(",");
        assertThatThrownBy(() -> carNameValidate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5글자 이내여야 합니다.");
    }

    @Test
    void tryCountInputCharValidateTest() {
        String input = "a";
        assertThatThrownBy(() -> tryCountValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 자연수이어야 합니다.");
    }

    @Test
    void tryCountInputMinusValidateTest() {
        String input = "-1";
        assertThatThrownBy(() -> tryCountValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 자연수이어야 합니다.");
    }

    @Test
    void tryCountInputZeroValidateTest() {
        String input = "0";
        assertThatThrownBy(() -> tryCountValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1 이상이어야 합니다.");
    }

}