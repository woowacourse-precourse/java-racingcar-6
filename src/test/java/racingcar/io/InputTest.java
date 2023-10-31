package racingcar.io;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import validation.InputValidate;

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
    void 이름이_없는_경우_에러가_발생한다() {
        String input = "abc,,def,ghi";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> InputValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1이상 5이하만 가능합니다.");
    }

}