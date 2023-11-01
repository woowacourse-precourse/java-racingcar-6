package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MyApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 한명만_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("hwang,jung", "3");
                    assertThat(output()).contains("최종 우승자 : jung");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("hwang,jung", "3");
                    assertThat(output()).contains("최종 우승자 : hwang, jung");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 아무도_전진하지_못한_경우_우승자_없음() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("hwang,jung", "3");
                    assertThat(output()).contains("최종 우승자 : 우승자는 없습니다.");
                },
                STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
