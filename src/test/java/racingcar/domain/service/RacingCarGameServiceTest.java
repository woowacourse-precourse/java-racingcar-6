package racingcar.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.GameType;
import racingcar.domain.entity.RacingCarGame;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.exception.validtaion.RacingCarGameValidationHandler;
import racingcar.input.RacingCarGameInput;

class RacingCarGameServiceTest {

    RacingCarGameRepository racingCarGameRepository = new RacingCarGameRepository();
    RacingCarGameService racingCarGameService = new RacingCarGameService(racingCarGameRepository);

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수와 자동차를 등록한다.")
    void registerCarAndGameCounter() {
        // given
        String gameCount = "100";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RacingCarGameInput input = new RacingCarGameInput(1L, GameType.RACING_CAR_GAME, gameCount, cars);

        // when
        racingCarGameService.registerCarAndGameCounter(input);

        // then
        RacingCarGame racingCarGame = racingCarGameRepository.findById(1L).get();
        assertAll(
                () -> assertThat(racingCarGame).isNotNull(),
                () -> assertThat(racingCarGame.getGameCount()).isEqualTo(100L),
                () -> assertThat(racingCarGame.getCars()).hasSize(3)
                        .extracting("carName", "distance")
                        .contains(
                                Tuple.tuple("pobi", 0),
                                Tuple.tuple("won", 0),
                                Tuple.tuple("jang", 0)
                        ),
                () -> assertThat(racingCarGame.getGameName()).isEqualTo(GameType.RACING_CAR_GAME),
                () -> assertThat(racingCarGame.getWinnerNames()).isEmpty()
        );
    }

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수가 없으면 예외가 발생한다.")
    void registerCarAndGameCounterPromptException() {
        // given
        String gameCount = " ";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RacingCarGameInput input = new RacingCarGameInput(1L, GameType.RACING_CAR_GAME, gameCount, cars);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.registerCarAndGameCounter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.PROMPT_GAME_COUNT_INPUT);
    }

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수가 숫자가 아니면 예외가 발생한다.")
    void registerCarAndGameCounterNumericException() {
        // given
        String gameCount = "five";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RacingCarGameInput input = new RacingCarGameInput(1L, GameType.RACING_CAR_GAME, gameCount, cars);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.registerCarAndGameCounter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.GAME_COUNT_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수가 100보다 크면 예외가 발생한다.")
    void registerCarAndGameCounterNumericOver100Exception() {
        // given
        String gameCount = "101";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RacingCarGameInput input = new RacingCarGameInput(1L, GameType.RACING_CAR_GAME, gameCount, cars);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.registerCarAndGameCounter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.MAX_GAME_COUNT_RESTRICTION);
    }
}