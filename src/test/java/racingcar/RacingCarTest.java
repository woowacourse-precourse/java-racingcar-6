package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 자동차_이름_구분() {
        // given
        String car1 = "wiz";
        String car2 = "JiHye";
        String input = car1 + "," + car2;

        // when
        Map<String, Integer> racingCars = Application.validateCarName(input);

        // then
        assertThat(racingCars).containsKey(car1);
        assertThat(racingCars).containsKey(car2);
    }

    @Test
    void 자동차_이름_구분시_자동차_이름이_5자를_초과할_때_예외_발생() {
        // given
        String car1 = "wisdom";

        // when & then
        assertThatThrownBy(() -> Application.validateCarName(car1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 시도할_회수_입력시_숫자가_아닐_때_예외_발생() {
        // given
        String input = "하나";

        // when & then
        assertThatThrownBy(() -> Application.parseInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닙니다.");
    }

}
