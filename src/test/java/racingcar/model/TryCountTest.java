package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

public class TryCountTest {

    @Test
    void 숫자_아닌_이동횟수_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new TryCount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_ONLY_NUMBER));
    }

    @Test
    void 이동횟수_0_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new TryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_POSITIVE_NUMBER_RANGE));
    }

    @Test
    void 값_제대로_저장되는지_테스트() {
        String value = "5";
        TryCount tryCount = new TryCount(value);
        assertThat(tryCount.value()).isEqualTo(Integer.parseInt(value));
    }
}