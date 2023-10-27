package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.TryNumber;

public class TryNumberTest {
    @Test
    void 시도횟수_1보다_작을_때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    TryNumber tryNumber = new TryNumber("0");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_음수일_때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    TryNumber tryNumber = new TryNumber("-1");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_소수일_때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    TryNumber tryNumber = new TryNumber("1.2");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
