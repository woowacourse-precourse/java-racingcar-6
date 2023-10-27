package racingcar.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarValidatorTest {

    @Test
    void 입력받은_차_이름_공백인_경우_예외() {
        String input = " ";
        Assertions.assertThatThrownBy(() -> CarValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백을 허용하지 않습니다.");
    }

    /**
     * 구분자가 쉼표가 아닌 경우 + 이름이 5글자 이상인 경우 한번에 처리 된다.
     * pobi.,sola.. -> ["pobi.", "sola.."] "sola.." 6글자 이므로 (예외 O)
     * pobi.,sola. -> ["pobi.", "sola."] 닉네임에 .이 붙은 것이므로 (예외 X)
     */
    @Test
    void 입력받은_차_이름_쉼표로_구분해_이름이_5글자_이상인_경우_예외() {
        String input = "pobi,woni,jun,sola.love"; // [pobi,woni,jun,sola.love]

        Assertions.assertThatThrownBy(() -> CarValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 최대 5글자 입니다.");
    }

    @Test
    void 입력받은_차_이름_쉼표로_시작한_경우_예외() {
        String input = ",pobi,woni,jun";
        Assertions.assertThatThrownBy(() -> CarValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 콤마(',')로 시작할 수 없습니다.");
    }

    @Test
    void 입력받은_차_이름_쉼표로_끝나는_경우_예외() {
        String input = "pobi,woni,jun,";
        Assertions.assertThatThrownBy(() -> CarValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 콤마(',')로 끝날수 없습니다.");
    }

    @Test
    void 입력받은_차_이름_쉼표가_연속된_경우_예외() {
        String input = "pobi,,woni,jun";
        Assertions.assertThatThrownBy(() -> CarValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 연속된 콤마(',')을 허용하지 않습니다.");
    }
}
