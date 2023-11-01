package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차 이름을 5글자 이상 입력 할 경우 예외 발생")
    void inputOverThenFiveLetters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,yeseul", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("랜덤 값이 4 이상의 값이면 전진, 아니라면 정지")
    void goForwardOverThenFourNumber() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ye,seul", "1");
                    assertThat(output()).contains("ye : -", "seul : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("입력한 게임 라운드 수에 따른 진행 상황 중계")
    void broadCastGameBoardAboutRoundNumber() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ye,seul", "3");
                    assertThat(output()).contains("ye : -", "ye : --", "ye : ---");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("승자가 한 명일 때")
    void makeWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ye,seul", "1");
                    assertThat(output()).contains("최종 우승자 : ye");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("승자가 여러 명일 때")
    void makeWinners() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ye,seul", "1");
                    assertThat(output()).contains("최종 우승자 : ye, seul");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
