package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingCarGameUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 성공 케이스")
    void CARS_객체_생성_성공() {
        String names = "현대,기아,쉐보레";
        assertThat(Cars.from(RacingCarGameUtil.splitName(names))).isInstanceOf(Cars.class);
    }

    @Test
    @DisplayName("Cars 객체 생성 실패 케이스")
    void CARS_객체_생성_실패() {
        String names = "현대,기아,쉐보레,이것은 자동차가 아닙니다.";
        assertThatThrownBy(() -> Cars.from(RacingCarGameUtil.splitName(names)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 값 입니다.");
    }
}
