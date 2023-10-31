package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import racingcar.model.RacingGame;
import racingcar.stub.RacingGameStub;

public class RacingGameTest extends RacingGameStub {

    private static RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = RacingGame.of(CAR_NAMES, TRIAL_COUNT);
    }

    @Test
    void 시도_횟수만큼_현재_차수를_증가하면_종료_상태로_변경() {
        IntStream.range(0, Integer.parseInt(TRIAL_COUNT))
                .forEach(i -> racingGame.increaseCurrentRound());

        assertThat(racingGame.isNotFinished())
                .isFalse();
    }

    @Test
    void 난수_생성_결과가_4_이상이면_전진() {
        try (MockedStatic<Randoms> randomsMockedStatic = BDDMockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4);

            racingGame.runRound();

            assertThat(racingGame.getRunResultMessage())
                    .isEqualTo(RUN_RESULT_MESSAGE_MOVED);
        }

    }

    @Test
    void 난수_생성_결과가_4미만이면_정지() {
        try (MockedStatic<Randoms> randomsMockedStatic = BDDMockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3);

            racingGame.runRound();

            assertThat(racingGame.getRunResultMessage())
                    .isEqualTo(RUN_RESULT_MESSAGE_STOPPED);
        }
    }

    @Test
    void test() {
        racingGame.decideWinners();

        assertThat(racingGame.getFinalWinnerMessage())
                .isEqualTo(FINAL_WINNER_MESSAGE);
    }
}
