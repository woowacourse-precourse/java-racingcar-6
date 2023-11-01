package racingcar.application;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;
import racingcar.constant.Rule;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("잘못된 입력시 예외 테스트")
    @ParameterizedTest(name = "{displayName}: cars:{0}, round:{1}")
    @CsvSource(value = {"1,2,3|-1", "43,동글,동글|12", "a,b,c,,|1", "9|x"}, delimiter = '|')
    void checkException(String cars, String round) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(cars, round))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}