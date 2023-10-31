package racingcar.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.GameType;
import racingcar.domain.entity.RacingCarGame;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.domain.service.input.RegisterRacingCarGameInput;
import racingcar.exception.RacingCarGameException;
import racingcar.exception.RacingCarGameRepositoryException;
import racingcar.exception.validtaion.RacingCarGameValidationHandler;

class RacingCarGameServiceTest {

    RacingCarGameRepository racingCarGameRepository = new RacingCarGameRepository();
    CarRepository carRepository = new CarRepository();
    RacingCarGameService racingCarGameService = new RacingCarGameService(racingCarGameRepository);

    @BeforeEach
    void setUp() {
        carRepository.clearAll();
        racingCarGameRepository.clearAll();
    }

    @AfterEach
    void tearDown() {
        carRepository.clearAll();
        racingCarGameRepository.clearAll();
    }

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수와 자동차를 등록한다.")
    void registerCarAndGameCounter() {
        // given
        Long racingGameId = 1L;
        String gameCount = "100";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, cars);

        // when
        racingCarGameService.registerCarsAndGameCounter(input);

        // then
        RacingCarGame racingCarGame = racingCarGameRepository.findById(racingGameId).get();
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
        Long racingGameId = 1L;
        String gameCount = " ";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, cars);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.registerCarsAndGameCounter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.PROMPT_GAME_COUNT_INPUT);
    }

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수가 숫자가 아니면 예외가 발생한다.")
    void registerCarAndGameCounterNumericException() {
        // given
        Long racingGameId = 1L;
        String gameCount = "five";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, cars);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.registerCarsAndGameCounter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.GAME_COUNT_FORMAT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 경주 게임에 필요한 시도할 횟수가 100보다 크면 예외가 발생한다.")
    void registerCarAndGameCounterNumericOver100Exception() {
        // given
        Long racingGameId = 1L;
        String gameCount = "101";

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, cars);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.registerCarsAndGameCounter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingCarGameValidationHandler.MAX_GAME_COUNT_RESTRICTION);
    }

    @Test
    @DisplayName("자동차 경주가 시작하면, 자동차 게임 횟수와 움직인 자동차의 거리를 계산한다.")
    void computeCarsDistanceAndGameCount() {
        // given
        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        carRepository.save(car1);
        carRepository.save(car2);

        car1.changeDistance(1);

        Long racingGameId = 1L;
        String gameCount = "5";
        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, List.of(car1, car2));

        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);
        racingCarGameRepository.save(racingCarGame);

        // when
        RacingCarGame racingCarGameResult = racingCarGameService.computeCarsDistanceAndGameCount(racingGameId,
                racingCarGame.getCars());

        // then
        assertAll(
                () -> assertThat(racingCarGameResult.getGameCount()).isEqualTo(4L),
                () -> assertThat(racingCarGameResult.getCars()).hasSize(2)
                        .extracting("carName", "distance")
                        .containsExactly(
                                Tuple.tuple("pobi", 1),
                                Tuple.tuple("won", 0)
                        )
        );
    }

    @Test
    @DisplayName("자동차 경주 게임이 없으면 예외가 발생한다.")
    void computeCarsDistanceAndGameCountException() {
        // given
        Long racingGameId = 1L;

        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");
        List<Car> cars = List.of(car1, car2, car3);

        // when // then
        assertThatThrownBy(
                () -> racingCarGameService.computeCarsDistanceAndGameCount(racingGameId, cars))
                .isInstanceOf(RacingCarGameRepositoryException.class)
                .hasMessage(RacingCarGameRepositoryException.NOT_FOUND);
    }

    @Test
    @DisplayName("자동차 경주 게임의 우승자 이름을 반환한다.")
    void computeGameWinners() {
        // given
        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");

        car1.changeDistance(1);
        car2.changeDistance(2);
        car3.changeDistance(3);
        String winnerNames = "jang";

        Long racingGameId = 1L;
        String gameCount = "0";
        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, List.of(car1, car2, car3));

        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);
        racingCarGameRepository.save(racingCarGame);

        // when
        List<String> findWinnerNames = racingCarGameService.computeGameWinners(racingGameId);

        // then
        RacingCarGame findRacingGame = racingCarGameRepository.findById(racingGameId).get();
        assertAll(
                () -> assertThat(findWinnerNames).hasSize(1)
                        .contains(winnerNames),
                () -> assertThat(findRacingGame.getWinnerNames()).hasSize(1)
                        .contains(winnerNames)
        );
    }

    @Test
    @DisplayName("자동차 경주 게임의 우승자가 여러명이면 여러명의 이름을 오름차순으로 반환한다.")
    void computeGameWinnersMany() {
        // given
        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");

        car1.changeDistance(2);
        car2.changeDistance(2);
        car3.changeDistance(2);
        String winnerNames1 = "jang";
        String winnerNames2 = "pobi";
        String winnerNames3 = "won";

        Long racingGameId = 1L;
        String gameCount = "0";
        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, List.of(car1, car2, car3));

        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);
        racingCarGameRepository.save(racingCarGame);

        // when
        List<String> findWinnerNames = racingCarGameService.computeGameWinners(racingGameId);

        // then
        RacingCarGame findRacingGame = racingCarGameRepository.findById(racingGameId).get();
        assertAll(
                () -> assertThat(findWinnerNames).hasSize(3)
                        .containsExactly(winnerNames1, winnerNames2, winnerNames3),
                () -> assertThat(findRacingGame.getWinnerNames()).hasSize(3)
                        .containsExactly(winnerNames1, winnerNames2, winnerNames3)
        );
    }

    @Test
    @DisplayName("자동차 경주 게임이 없으면 예외가 발생한다.")
    void computeGameWinnersNotFoundGameException() {
        // given
        Long racingGameId = 1L;

        // when // then
        assertThatThrownBy(() -> racingCarGameService.computeGameWinners(racingGameId))
                .isInstanceOf(RacingCarGameRepositoryException.class)
                .hasMessage(RacingCarGameRepositoryException.NOT_FOUND);
    }

    @Test
    @DisplayName("자동차 경주 게임 종료 조건이 아니면 예외가 발생한다.")
    void computeGameWinnersEndConditionException() {
        // given
        Car car1 = Car.create("pobi");
        Car car2 = Car.create("won");
        Car car3 = Car.create("jang");

        Long racingGameId = 1L;
        String gameCount = "1"; // 게임 종료 조건이 아님
        RegisterRacingCarGameInput input = new RegisterRacingCarGameInput(racingGameId,
                GameType.RACING_CAR_GAME, gameCount, List.of(car1, car2, car3));

        RacingCarGame racingCarGame = RacingCarGame.createWithoutWinnerNames(input);
        racingCarGameRepository.save(racingCarGame);

        // when // then
        assertThatThrownBy(() -> racingCarGameService.computeGameWinners(racingGameId))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessage(RacingCarGameException.NOT_GAME_END_CONDITION_RESTRICTION);
    }
}