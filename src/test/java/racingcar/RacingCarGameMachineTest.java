package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarGameMachineTest {

    private RacingCarMachine racingCarMachine;

    private static final String RACING_CAR_NAME_INPUT = "semin,woowa,pre";
    private static final int ROUND_COUNT = 5;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void init() {
        MockRandomNumberGenerator randomNumberGenerator = new MockRandomNumberGenerator(MOVING_FORWARD, STOP, STOP);
        this.racingCarMachine = new RacingCarMachine(randomNumberGenerator);
        racingCarMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);
    }

    @Test
    void 레이싱카_생성() {
        String roundResult = racingCarMachine.playRound();

        Assertions.assertThat(roundResult).contains("semin", "woowa", "pre");
    }

    @Test
    void 게임_진행_중() {
        boolean gameInProgress = racingCarMachine.isGameInProgress();

        Assertions.assertThat(gameInProgress).isEqualTo(true);
    }

    @Test
    void 게임_종료() {
        for (int i = 0; i < ROUND_COUNT; i++) {
            racingCarMachine.playRound();
        }
        boolean gameInProgress = racingCarMachine.isGameInProgress();

        Assertions.assertThat(gameInProgress).isEqualTo(false);
    }

    @Test
    void 라운드_지정_횟수_초과_예외처리() {
        playRoundUntilGameOver();

        Assertions.assertThatThrownBy(() -> racingCarMachine.playRound())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 라운드_결과() {
        String roundResult = racingCarMachine.playRound();

        Assertions.assertThat(roundResult).contains("semin : -");
        Assertions.assertThat(roundResult).doesNotContain("woowa : -", "pre : -");
    }

    @Test
    void 게임_진행_중_결과_호출_예외_처리() {
        Assertions.assertThatThrownBy(() -> racingCarMachine.getGameResult())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 단독_우승() {
        playRoundUntilGameOver();
        String gameResult = racingCarMachine.getGameResult();

        Assertions.assertThat(gameResult).contains("최종 우승자 : semin");
        Assertions.assertThat(gameResult).doesNotContain("woowa", "pre");
    }

    @Test
    void 동점_우승() {
        MockRandomNumberGenerator randomNumberGenerator
                = new MockRandomNumberGenerator(MOVING_FORWARD, MOVING_FORWARD, STOP);
        this.racingCarMachine = new RacingCarMachine(randomNumberGenerator);
        racingCarMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        playRoundUntilGameOver();
        String gameResult = racingCarMachine.getGameResult();

        Assertions.assertThat(gameResult).contains("최종 우승자 : semin, woowa");
        Assertions.assertThat(gameResult).doesNotContain("pre");
    }

    void playRoundUntilGameOver() {
        while (racingCarMachine.isGameInProgress()) {
            racingCarMachine.playRound();
        }
    }
}
