package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름을 쉼표를 기준으로 구분하여 입력받을 수 있다")
    void ask_car_name_success() {
        InputView inputView = new InputView(() -> "jae,jaeh,kim");
        assertThat(inputView.askCarNames()).containsExactly("jae", "jaeh", "kim");
    }
}
