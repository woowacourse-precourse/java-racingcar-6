package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingGameTest extends NsTest {

    @Test
    @DisplayName("모두 멈춤상태로 아무도 전진하지 못할 경우 공동우승 테스트")
    void run() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("bobo,judy,jin", "2");
                    assertThat(output()).contains("최종 우승자 : bobo, judy, jin");
                },
                1, 1, 3, 1, 1, 1
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}