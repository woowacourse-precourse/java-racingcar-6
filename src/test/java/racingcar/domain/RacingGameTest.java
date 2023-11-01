package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String[] carNames = {"car1", "car2", "car3"};
        int rounds = 5;
        racingGame = new RacingGame(carNames, rounds);
    }

    @Test
    void 생성시_주어진_자동차_이름으로_자동차_초기화() {
        List<Car> cars = racingGame.playRound();
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting("name")
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    void 우승자_확인() {
        for (int i = 0; i < 5; i++) {
            racingGame.playRound();
        }

        List<String> winners = racingGame.getWinners();
        assertThat(winners).isNotEmpty();
    }

    @Test
    void 라운드_수_확인() {
        int rounds = racingGame.getRounds();
        assertThat(rounds).isEqualTo(5);
    }
}
