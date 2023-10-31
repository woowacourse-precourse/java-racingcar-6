package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름입력_받기와_처리() {
        assertSimpleTest(() -> {
            run("pobi,minju", "1");
            assertThat(output()).contains("minju :");
            assertThat(output()).contains("pobi : ");
        });

    }

    @Test
    void 실시횟수_입력받고_저장() {
        assertSimpleTest(() -> {
            run("pobi,minju", "1");

            String result = output();
            int roundsCount = 0;
            roundsCount += (result.length() - result.replace("pobi","").length()) / 4;

            assertThat(roundsCount < 3).isTrue();
            assertThat(roundsCount > 0).isTrue();
        });
    }

    @Test
    void 우승자를_판단해서_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,minju", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, minju");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
