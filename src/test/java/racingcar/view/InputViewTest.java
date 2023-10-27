package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("각 이름이 쉼표에 의해 잘 나누어지는지 확인")
    public void inputNames() {
        assertThat(InputView.inputNames("poky,minsu,pobi"))
                .contains("poky", "minsu", "pobi");
    }

    @Test
    @DisplayName("반복 횟수 입력값이 올바르게 변환되는지 확인")
    public void inputRepeat() {
        assertThat(InputView.inputRepeat("17"))
                .isEqualTo(17);
    }

    @Test
    @DisplayName("반복 횟수 입력값이 변환할 수 없는 형태일 경우 에러를 발생시키는지")
    public void inputRepeatError() {
        // 한글 입력
        assertThatThrownBy(() -> InputView.inputRepeat("쿠키"))
                .isInstanceOf(IllegalArgumentException.class);
        // 영어 입력
        assertThatThrownBy(() -> InputView.inputRepeat("s11"))
                .isInstanceOf(IllegalArgumentException.class);
        // 공백 포함
        assertThatThrownBy(() -> InputView.inputRepeat("13 "))
                .isInstanceOf(IllegalArgumentException.class);
        // 소수점을 포함한 실수 형태
        assertThatThrownBy(() -> InputView.inputRepeat("17.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
