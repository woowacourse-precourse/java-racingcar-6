package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.condition.MoveCondition;
import racingcar.domain.random.DoubleRandomService;
import racingcar.domain.random.RandomNumberFactory;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;

class RacingGameTest {

    @Test
    @DisplayName("RacingGameRq를 받아 게임을 실행해 결과인 RacingGameRs를 반환한다.")
    void startGame() {
        // given
        RacingCarDto k5 = RacingCarDto.valueOf(new RacingCar("k5", 0, new MoveCondition()));
        RacingCarDto k3 = RacingCarDto.valueOf(new RacingCar("k3", 2, new MoveCondition()));
        RacingGameRq racingGameRq = RacingGameRq.valueOf(List.of(k5, k3), 3);
        RacingGame racingGame = new RacingGame(new RandomNumberFactory(new DoubleRandomService(5)));

        // when
        RacingGameRs racingGameRs = racingGame.startGame(racingGameRq);

        // then
        assertThat(racingGameRs.getRacingCarDtoList())
                .extracting("carName", "position")
                .containsExactlyInAnyOrder(
                        tuple("k5", 1),
                        tuple("k3", 3)
                );
    }
}