package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;

public class ValidatorTest {
    CarController carController = new CarController();

    @Test
    void 자동차이름_다섯글자초과_예외처리() {
        String input = "aaa,bbb,cccccc";

        assertThatThrownBy(() -> carController.convertStringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~5글자인 자동차 이름만 입력 가능합니다.");
    }

    @Test
    void 자동차이름_한글자미만_예외처리() {
        String input = "aaa,,ccc";

        assertThatThrownBy(() -> carController.convertStringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~5글자인 자동차 이름만 입력 가능합니다.");
    }

    @Test
    void 자동차이름_공백_예외처리() {
        String input = "aaa,b b,ccc";

        assertThatThrownBy(() -> carController.convertStringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 공백이 있으면 안됩니다.");
    }

    @Test
    void 자동차이름_중복_예외처리() {
        String input = "aaa,bbb,aaa";

        assertThatThrownBy(() -> carController.convertStringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 목록은 중복이 없어야 합니다.");
    }

    @Test
    void 시도횟수_숫자_아닌_경우_예외처리() {
        String input = "a";

        assertThatThrownBy(() -> carController.convertStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자여야 합니다.");
    }
}
