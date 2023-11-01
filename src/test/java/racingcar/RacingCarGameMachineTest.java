package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockRacingCarGameFactory;
import racingcar.mock.MockRandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    }

    @Test
    void 초기화_하지_않고_게임_실행_예외_처리() {
        assertThatThrownBy(() -> racingCarGameMachine.getRoundResult())
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> racingCarGameMachine.getGameResult())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 레이싱카_생성() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        String roundResult = racingCarGameMachine.getRoundResult();

        assertThat(roundResult).contains("semin", "woowa", "pre");
    }

    @Test
    void 라운드_진행_가능() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        boolean gameInProgress = racingCarGameMachine.canPlayRound();

        assertThat(gameInProgress).isEqualTo(true);
    }

    @Test
    void 라운드_진행_불가능() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        playRoundUntilGameOver();
        boolean gameInProgress = racingCarGameMachine.canPlayRound();

        assertThat(gameInProgress).isEqualTo(false);
    }

    @Test
    void 라운드_지정_횟수_초과_예외처리() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        playRoundUntilGameOver();

        assertThatThrownBy(() -> racingCarGameMachine.getRoundResult())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 라운드_결과() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        mockRandomNumberGenerator.init(MOVING_FORWARD, STOP, STOP);

        String roundResult = racingCarGameMachine.getRoundResult();

        assertThat(roundResult).contains("semin : -");
        assertThat(roundResult).doesNotContain("woowa : -", "pre : -");
    }

    @Test
    void 게임_진행_중_결과_호출_예외_처리() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        assertThatThrownBy(() -> racingCarGameMachine.getGameResult())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 단독_우승() {
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        mockRandomNumberGenerator.init(MOVING_FORWARD, STOP, STOP);
        playRoundUntilGameOver();
        String gameResult = racingCarGameMachine.getGameResult();

        assertThat(gameResult).contains("최종 우승자 : semin");
        assertThat(gameResult).doesNotContain("woowa", "pre");
    }

    @Test
    void 동점_우승() {
        mockRandomNumberGenerator.init(MOVING_FORWARD, MOVING_FORWARD, STOP);
        racingCarGameMachine.init(RACING_CAR_NAME_INPUT, ROUND_COUNT);

        playRoundUntilGameOver();

        String gameResult = racingCarGameMachine.getGameResult();

        assertThat(gameResult).contains("최종 우승자 : semin, woowa");
        assertThat(gameResult).doesNotContain("pre");
    }

    void playRoundUntilGameOver() {
        while (racingCarGameMachine.canPlayRound()) {
            racingCarGameMachine.getRoundResult();
        }
    }
}
