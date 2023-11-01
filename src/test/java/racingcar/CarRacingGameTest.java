package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarRacingGameTest extends NsTest {
    @Test
    void 최종_우승자가_여러명일_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                run("jun,camel,poro", "1");
                assertThat(output()).contains("jun : -", "camel : -", "poro : -", "최종 우승자 : jun, camel, poro");
            },
            5, 6, 8
        );
    }

    @Test
    void 경주할_자동차_설정_중_입력값에_쉼표가_없는_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi/jun/java", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 경주할_자동차_설정_중_중복된_이름이_있는_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("jun,jun,camel", "3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 시도_횟수_설정_중_값이_0_이하인_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("jun,pobi,camel", "-3"))
                .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}