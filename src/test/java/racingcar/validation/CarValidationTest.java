package racingcar.validation;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarValidationTest {
    @Test
    void 이름의_길이가_5자_초과인_경우_에러가_발생한다() {
        String input = "user,userName";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> CarValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1이상 5이하만 가능합니다.");
    }

    @Test
    void 이름에_공백이_존재하는_경우_에러가_발생한다() {
        String input = "user,u ser";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> CarValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 공백이 포함될 수 없습니다.");
    }

    @Test
    void 이름이_중복되는_경우_에러가_발생한다() {
        String input = "user,user";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> CarValidate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 참가자_수가_10명_이상인_경우__에러가_발생한다() {
        String input = "a,b,c,d,e,f,g,h,i,j,k";
        List<String> carNames = List.of(input.split(","));

        Assertions.assertThatThrownBy(() -> CarValidate.participantCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 게임에 참여할 수 있는 인원은 최대 10명입니다.");
    }
}
