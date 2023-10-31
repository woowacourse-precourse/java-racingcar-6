package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름을 쉼표를 기준으로 구분하여 입력받을 수 있다")
    void ask_car_name_success() {
        InputView inputView = new InputView(() -> "jae,jaeh,kim");
        assertThat(inputView.askCarNames()).containsExactly("jae", "jaeh", "kim");
    }

    @Test
    @DisplayName("시도할 회수를 입력받을 수 있다")
    void ask_round_number_success() {
        InputView inputView = new InputView(() -> "5");
        assertThat(inputView.askRoundNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("입력받은 시도할 회수가 숫자가 아닐 시 예외를 던진다")
    void ask_round_number_fail_not_number() {
        InputView inputView = new InputView(() -> "kkk");
        assertThatThrownBy(inputView::askRoundNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
