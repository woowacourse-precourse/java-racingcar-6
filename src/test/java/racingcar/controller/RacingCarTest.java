package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingCarTest extends NsTest {
    @Test
    @DisplayName("컨트롤러 정상 작동 테스트")
    void testRacingCarController1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("Test1,Test2", "3");
                    assertThat(output()).contains("Test1 : -", "Test2 : ");
                    assertThat(output()).contains("Test1 : -", "Test2 : ");
                    assertThat(output()).contains("Test1 : --", "Test2 : ");
                    assertThat(output()).contains("최종 우승자 : Test1");
                },
                4, 3, 1, 3, 9, 1
        );
    }

    @Test
    @DisplayName("우승자 다수 테스트")
    void testRacingCarController2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("Test1,Test2", "1");
                    assertThat(output()).contains("Test1 : -", "Test2 : ");
                    assertThat(output()).contains("최종 우승자 : Test1, Test2");
                },
                4, 6
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
