package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private static final String JACK = "jack";
    private static final String CRONG = "crong";
    private static final int TRY_COUNT_3 = 3;
    private static final MovementCondition MOVABLE = () -> true;
    private static final MovementCondition IMMOVABLE = () -> false;
    private static final Car CAR_JACK_0_POSITION = createCar(JACK, 0);
    private static final Car CAR_CRONG_0_POSITION = createCar(CRONG, 0);

    @Test
    void 자동차_그룹과_시도횟수를_통해_레이싱_게임을_생성할_수_있다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        TryCount tryCount = createTryCount(TRY_COUNT_3);

        assertDoesNotThrow(
                () -> RacingGame.of(carGroup, tryCount)
        );
    }

    @Test
    void 시도_회수_만큼_경기_스테이지_기록을_생성한다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        TryCount tryCount = createTryCount(TRY_COUNT_3);
        RacingGame racingGame = createRacingGame(carGroup, tryCount);
        int expectedSize = 3;

        RaceHistory history = racingGame.startRaceWith(MOVABLE);

        assertThat(history.getRaceStages())
                .hasSize(expectedSize);
    }

    @Test
    void 항상_움직이는_조건인_경우_시도_회수만큼_위치값이_증가한다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        TryCount tryCount = createTryCount(TRY_COUNT_3);
        RacingGame racingGame = createRacingGame(carGroup, tryCount);

        RaceHistory history = racingGame.startRaceWith(MOVABLE);

        assertThat(history.getRaceStages())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                        createRaceStage(createCar(JACK, 1), createCar(CRONG, 1)),
                        createRaceStage(createCar(JACK, 2), createCar(CRONG, 2)),
                        createRaceStage(createCar(JACK, 3), createCar(CRONG, 3))
                );

    }

    @Test
    void 항상_움직이지_않는_조건인_경우_시도_회수만큼_위치값이_증가하지_않는다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        TryCount tryCount = createTryCount(TRY_COUNT_3);
        RacingGame racingGame = createRacingGame(carGroup, tryCount);

        RaceHistory history = racingGame.startRaceWith(IMMOVABLE);

        assertThat(history.getRaceStages())
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                        createRaceStage(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION),
                        createRaceStage(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION),
                        createRaceStage(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION)
                );

    }

    private static Car createCar(String name, int position) {
        CarName carName = CarName.from(name);
        CarPosition carPosition = new CarPosition(position);
        return new Car(carName, carPosition);
    }

    private CarGroup createCarGroup(Car... cars) {
        return new CarGroup(List.of(cars));
    }

    private TryCount createTryCount(int tryCount) {
        return TryCount.from(tryCount);
    }

    private RaceStage createRaceStage(Car carJack0Position, Car carCrong0Position) {
        return RaceStage.from(createCarGroup(carJack0Position, carCrong0Position));
    }

    private RacingGame createRacingGame(CarGroup carGroup, TryCount tryCount) {
        return RacingGame.of(carGroup, tryCount);
    }
}
