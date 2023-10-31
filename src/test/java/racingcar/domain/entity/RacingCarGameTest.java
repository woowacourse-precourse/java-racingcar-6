package racingcar.domain.entity;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.service.input.RegisterRacingCarGameInput;
import racingcar.exception.RacingCarGameException;

class RacingCarGameTest {
    @Test
    @DisplayName("시도할 게임 횟수가 0이상이면 예외가 발생하지 않는다.")
    void changeGameCount() {
        // given
        String gameCount = "0";
        Long racingGameId = 1L;

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, cars);

        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);

        // when
        racingCarGame.changeGameCount(Long.parseLong(gameCount));

        // then
        assertThat(racingCarGame.getGameCount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("시도할 게임 횟수가 음수이면 예외가 발생한다.")
    void changeGameCountException() {
        // given
        String gameCount = "-1";
        Long racingGameId = 1L;

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, cars);

        // when
        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);

        // then
        assertThatThrownBy(() -> racingCarGame.changeGameCount(Long.parseLong(gameCount)))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessage(RacingCarGameException.NON_NEGATIVE_GAME_COUNT_RESTRICTION);
    }
}