package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.numberpicker.RandomNumberPicker;
import racingcar.mock.FakeRandomNumberPicker;

class RacingGameTest {

    @DisplayName("게임을 새로 생성하면 게임 상태는 IN_PROGRESS 이다.")
    @Test
    void newGame() {
        // given
        Cars cars = new Cars(List.of(
                Car.nameOf(new CarName("haero")),
                Car.nameOf(new CarName("pobi"))
        ));
        long movingCount = 1L;

        // when
        RacingGame racingGame = RacingGame.newGame(cars, movingCount);

        // then
        assertThat(racingGame.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }

    @DisplayName("이동 횟수를 모두 소진하면 게임 상태는 END이다.")
    @ParameterizedTest
    @ValueSource(longs = {1L, 10L, 100L})
    void movingCount(long movingCount) {
        // given
        Cars cars = new Cars(List.of(
                Car.nameOf(new CarName("haero")),
                Car.nameOf(new CarName("pobi"))
        ));
        RacingGame racingGame = RacingGame.newGame(cars, movingCount);

        RandomNumberPicker randomNumberPicker = new FakeRandomNumberPicker(4);

        // when
        for (int count = 0; count < movingCount; count++) {
            racingGame.moveOnce(randomNumberPicker);
        }

        // then
        assertAll(
                () -> assertThat(racingGame.getGameStatus()).isEqualTo(GameStatus.END),
                () -> assertThat(racingGame)
                        .extracting("movingCount")
                        .isEqualTo(0L)
        );
    }

}