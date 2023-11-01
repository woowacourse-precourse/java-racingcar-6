package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.PerGameCarResultDto;

class RacingGameTest {

    @Test
    void startRacingGame() {
        RacingGame racingGame = new RacingGame(List.of("pobi", "nana", "boo"), 1);

        List<PerGameCarResultDto> perGameCarResultDtos = racingGame.startRacingGame();
        Assertions.assertThat(perGameCarResultDtos.size()).isEqualTo(3);
    }

    @Test
    void getRacingWinner() {
    }

    @Test
    void isEndGame() {

    }
}