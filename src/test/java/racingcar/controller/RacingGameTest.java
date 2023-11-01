package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingGameTest extends NsTest {

    @Test
    void run() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("bobo,judy,jin", "2");
                    assertThat(output()).contains("최종 우승자 : judy");
                },
                1, 4, 3, 5, 8, 9
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}