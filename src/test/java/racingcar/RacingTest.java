package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    @Test
    void 자동차_이름_나누기() {
        Racing racing = new Racing();
        String carNames = "midi,gumi,gymi";

        racing.splitCarName(carNames);
        assertThat(racing.carList.size()).isEqualTo(3);
    }

    @Test
    void 중복_자동차_이름_예외_테스트() {
        Racing racing = new Racing();
        String carNames = "mmm,kkk,mmm";

        assertThatThrownBy(() -> racing.splitCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력없음_예외_테스트() {
        Racing racing = new Racing();
        String carNames = "";

        assertThatThrownBy(() -> racing.splitCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_시도_회수_입력_예외_테스트() {
        Racing racing = new Racing();
        String tryCount = "23@4";

        assertThatThrownBy(() -> racing.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_입력없음_예외_테스트() {
        Racing racing = new Racing();
        String tryCount = "";

        assertThatThrownBy(() -> racing.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
