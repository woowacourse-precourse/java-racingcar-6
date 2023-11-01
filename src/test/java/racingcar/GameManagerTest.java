package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Constant.*;

class GameManagerTest extends NsTestStudy {
    private static final int MOVING_FORWARD = Constant.MOVING_FORWARD;
    private static final int STOP = Constant.MOVING_FORWARD - 1;

    private static final String WINNER = "win";
    private static final String LOSER = "lose";
    private static final String EMPTY = ",";
    private static final String ROUND = "2";


    @Test
    @DisplayName("ApplicationTest_공부해보기_승자2점_패자0점_테스트")
    void play_whenWinnerPointIsTwoAndLoserPointIsZero() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(WINNER + INPUT_DELIM + LOSER, ROUND);
                    assertThat(output()).contains(WINNER + IS + LINE, LOSER + IS,
                            WINNER + IS + LINE + LINE, LOSER + IS,
                            MESSAGE_WINNER + IS + WINNER);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("ApplicationTest_공부해보기_자동차_이름_비어있을_때_에러발생")
    void play_whenNameIsEmpty_IllegalArgumentException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(EMPTY, ROUND))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_EMPTY_CAR_LIST)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}