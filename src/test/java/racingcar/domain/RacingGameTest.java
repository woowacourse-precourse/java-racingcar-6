package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.PerGameCarResultDto;

class RacingGameTest {

    @Test
    void startRacingGame() {
        RacingGame racingGame = new RacingGame(List.of("pobi", "nana", "boo"), 1);

        List<PerGameCarResultDto> perGameCarResultDtos = racingGame.startRacingGame();
        assertThat(perGameCarResultDtos.size()).isEqualTo(3);
    }

    @Test
    void getRacingWinner() {
        RacingGame racingGame = new RacingGame(List.of("pobi", "nana", "boo"), 1);
        assertThatThrownBy(racingGame::getRacingWinner)
            .isInstanceOf(IllegalArgumentException.class);

        racingGame.startRacingGame();
        assertThat(racingGame.getRacingWinner().size()).isGreaterThan(0);
    }

    @Test
    void isEndGame() {

    }
}