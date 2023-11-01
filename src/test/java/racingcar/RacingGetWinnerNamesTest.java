package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGetWinnerNamesTest extends NsTest {

    private static Racing racing;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void initRacing() {
        racing = new Racing();
    }

    @Test
    @DisplayName("getWinnerNames 단독 우승자 테스트")
    void getWinnerNames_solo_winner() {

        String[] carNames = {"레오", "딘", "푸주"};
        int playCount = 3;

        racing.initParticipants(carNames);
        racing.initPlayCount(playCount);

        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(racing.getWinnerNames()).contains("푸주");
                    assertThat(racing.getWinnerNames().size()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("getWinnerNames 복수 우승자 테스트")
    void getWinnerNames_plural_winner() {

        String[] carNames = {"레오", "딘", "푸주"};
        int playCount = 3;

        racing.initParticipants(carNames);
        racing.initPlayCount(playCount);

        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(racing.getWinnerNames()).contains("푸주", "레오");
                    assertThat(racing.getWinnerNames().size()).isEqualTo(2);
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        racing.getPlayResults();
    }
}
