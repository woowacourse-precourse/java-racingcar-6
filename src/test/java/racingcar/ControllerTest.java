package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    @DisplayName("이동 결과만큼 실행 결과가 출력된다.")
    void 실행결과_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("runa,crong,boo", "4");
                    assertThat(output()).contains("runa : ---", "crong : -", "boo : ----", "최종 우승자 : boo");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
