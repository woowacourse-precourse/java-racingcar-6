package racingcar.io;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validation.InputValidate;

class InputTest {
    @Test
    void 이름의_길이가_5자_초과인_경우_에러가_발생한다() {
        String input = "user,userName";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> InputValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1이상 5이하만 가능합니다.");
    }

    @Test
    void 이름에_공백이_존재하는_경우_에러가_발생한다() {
        String input = "user,u ser";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> InputValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 공백이 포함될 수 없습니다.");
    }

    @Test
    void 이름이_중복되는_경우_에러가_발생한다() {
        String input = "user,user";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> InputValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

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
    void 참가자_수가_10명_이상인_경우__에러가_발생한다() {
        String input = "a,b,c,d,e,f,g,h,i,j,k";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> InputValidate.participantCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 게임에 참여할 수 있는 인원은 최대 10명입니다.");
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