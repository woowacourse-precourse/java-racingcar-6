package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @Test
    void 이름_입력_형식이_쉼표로_시작하는_경우_에러가_발생한다() {
        String input = ",abc,def,ghi";

        Assertions.assertThatThrownBy(() -> InputValidate.nameFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 입력 형식이 올바르지 않습니다. 자동차 이름은 쉼표(,) 기준으로 구분됩니다.");
    }

    @Test
    void 이름_입력_형식에_쉼표가_연속으로_입력되는_경우_에러가_발생한다() {
        String input = "abc,,def,ghi";

        Assertions.assertThatThrownBy(() -> InputValidate.nameFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 입력 형식이 올바르지 않습니다. 자동차 이름은 쉼표(,) 기준으로 구분됩니다.");
    }

    @Test
    void 이름_입력_형식이_쉼표로_끝나는_경우_에러가_발생한다() {
        String input = "abc,def,ghi,";

        Assertions.assertThatThrownBy(() -> InputValidate.nameFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 입력 형식이 올바르지 않습니다. 자동차 이름은 쉼표(,) 기준으로 구분됩니다.");
    }

    @Test
    void 시도_횟수가_숫자가_아닌_경우_에러가_발생한다() {
        String input = "abc";

        Assertions.assertThatThrownBy(() -> InputValidate.gameRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수를 입력해 주세요");
    }

    @Test
    void 시도_횟수가_1에서_20_사이의_숫자가_아닌_경우_에러가_발생한다() {
        String zero = "0";

        Assertions.assertThatThrownBy(() -> InputValidate.gameRound(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 1이상 20이하만 가능합니다");

        String overRange = "21";

        Assertions.assertThatThrownBy(() -> InputValidate.gameRound(overRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드는 1이상 20이하만 가능합니다");
    }
}