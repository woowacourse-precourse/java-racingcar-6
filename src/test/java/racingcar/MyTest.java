package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest {

    @Test
    void 자동차이름_쉼표사이_이름없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사이클_0일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동우승자_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                4, 4
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
