package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest extends ApplicationTest {
    @Test
    void 이름_중복_유효성_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
            );
    }

    @Test
    void 이름_길이_유효성_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jjjjun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
