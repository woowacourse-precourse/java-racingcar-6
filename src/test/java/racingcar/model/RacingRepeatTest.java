package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingRepeatTest {
    @Test
    @DisplayName("반복 횟수 입력값이 변환할 수 없는 형태일 경우 에러를 발생시키는지")
    public void inputRepeatError() {
        // 한글 입력
        assertThatThrownBy(() -> new RacingRepeat("쿠키"))
                .isInstanceOf(IllegalArgumentException.class);
        // 영어 입력
        assertThatThrownBy(() -> new RacingRepeat("s11"))
                .isInstanceOf(IllegalArgumentException.class);
        // 공백 포함
        assertThatThrownBy(() -> new RacingRepeat("13 "))
                .isInstanceOf(IllegalArgumentException.class);
        // 소수점을 포함한 실수 형태
        assertThatThrownBy(() -> new RacingRepeat("17.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("반복 횟수 입력값 범위가 1이상의 정수가 아닌 경우 에러를 발생시키는지")
    public void inputRepeatRangeError() {
        assertThatThrownBy(() -> new RacingRepeat("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingRepeat("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
