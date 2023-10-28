package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarStatusTest {

    @Test
    @DisplayName("자동차의 상태를 정확하게 문자열로 변환한다.")
    public void toStringTest() {
        RacingCarStatus status = RacingCarStatus.of("abc", 5);
        String statusString = status.toString();

        assertThat(statusString).isEqualTo("abc : -----");
    }
}