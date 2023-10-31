package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockRacingCarGameFactory;
import racingcar.mock.MockRandomNumberGenerator;

public class RacingCarGameMachineTest {
    private static final RacingCarGameFactory racingCarGameFactory = new MockRacingCarGameFactory();
    private MockRandomNumberGenerator mockRandomNumberGenerator;
    private RacingCarGameMachine racingCarGameMachine;

    private static final String RACING_CAR_NAME_INPUT = "semin,woowa,pre";
    private static final int ROUND_COUNT = 5;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void init() {
        mockRandomNumberGenerator = (MockRandomNumberGenerator) racingCarGameFactory.randomNumberGenerator();
        racingCarGameMachine = racingCarGameFactory.racingCarGameMachine();

        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);
    }

    @Test
    void 레이싱카_생성() {
        String roundResult = racingCarGameMachine.getRoundResult();

        Assertions.assertThat(roundResult).contains("semin", "woowa", "pre");
    }

    @Test
    void 게임_진행_중() {
        boolean gameInProgress = racingCarGameMachine.isGameInProgress();

        Assertions.assertThat(gameInProgress).isEqualTo(true);
    }

    @Test
    void 게임_종료() {
        for (int i = 0; i < ROUND_COUNT; i++) {
            racingCarGameMachine.getRoundResult();
        }
        boolean gameInProgress = racingCarGameMachine.isGameInProgress();

        Assertions.assertThat(gameInProgress).isEqualTo(false);
    }

    @Test
    void 라운드_지정_횟수_초과_예외처리() {
        playRoundUntilGameOver();

        Assertions.assertThatThrownBy(() -> racingCarGameMachine.getRoundResult())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 라운드_결과() {
        mockRandomNumberGenerator.init(MOVING_FORWARD, STOP, STOP);

        String roundResult = racingCarGameMachine.getRoundResult();

        Assertions.assertThat(roundResult).contains("semin : -");
        Assertions.assertThat(roundResult).doesNotContain("woowa : -", "pre : -");
    }

    @Test
    void 게임_진행_중_결과_호출_예외_처리() {
        Assertions.assertThatThrownBy(() -> racingCarGameMachine.getGameResult())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 단독_우승() {
        mockRandomNumberGenerator.init(MOVING_FORWARD, STOP, STOP);
        playRoundUntilGameOver();
        String gameResult = racingCarGameMachine.getGameResult();

        Assertions.assertThat(gameResult).contains("최종 우승자 : semin");
        Assertions.assertThat(gameResult).doesNotContain("woowa", "pre");
    }

    @Test
    void 동점_우승() {
        mockRandomNumberGenerator.init(MOVING_FORWARD, MOVING_FORWARD, STOP);
        playRoundUntilGameOver();

        String gameResult = racingCarGameMachine.getGameResult();

        Assertions.assertThat(gameResult).contains("최종 우승자 : semin, woowa");
        Assertions.assertThat(gameResult).doesNotContain("pre");
    }

    void playRoundUntilGameOver() {
        while (racingCarGameMachine.isGameInProgress()) {
            racingCarGameMachine.getRoundResult();
        }
    }
}
