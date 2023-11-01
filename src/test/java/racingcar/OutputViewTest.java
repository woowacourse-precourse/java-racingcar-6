package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("전진 횟수 문자로 바꾸는 테스트")
    void 전진_횟수_문자로_바꾸는_테스트() {
        int movingCount = 4;
        String movingCountString = outputView.changeCarMovingCountToString(movingCount);
        assertThat(movingCountString).isEqualTo("----");
    }
}