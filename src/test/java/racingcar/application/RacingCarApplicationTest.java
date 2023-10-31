package racingcar.application;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.constant.Rule;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarApplicationTest extends NsTest {

    @DisplayName("공동 우승자 출력 테스트")
    @Test
    void checkJointWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("동글,화이팅", "3");
                    assertThat(output()).contains("최종 우승자 : 동글, 화이팅");
                },
                Rule.MAX_POSSIBILITY, Rule.MAX_POSSIBILITY,
                Rule.MAX_POSSIBILITY, Rule.MAX_POSSIBILITY,
                Rule.MAX_POSSIBILITY, Rule.MAX_POSSIBILITY
        );
    }

    @DisplayName("단독 우승자 출력 테스트")
    @Test
    void checkSoloWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("동글,화이팅", "3");
                    assertThat(output()).contains("최종 우승자 : 동글");
                },
                Rule.MAX_POSSIBILITY, Rule.MIN_POSSIBILITY,
                Rule.MAX_POSSIBILITY, Rule.MAX_POSSIBILITY,
                Rule.MAX_POSSIBILITY, Rule.MAX_POSSIBILITY
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}