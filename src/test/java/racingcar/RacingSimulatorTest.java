package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.StubNumberGenerator;
import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.model.Positions;
import racingcar.model.RacingGame;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    private static final int MOVE = 4;
    private static final int STOP = 3;

    @DisplayName("자동차 : 이름 5자 초과 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"ethaan   ", "veruasds   ", "   pasdobi\t\t\t"})
    void inputUnderFiveLength(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 : 경주 참여")
    @Test
    void mustParticipateTwoCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);

        assertThatThrownBy(() -> new RacingGame(1, numberGenerator, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 횟수 초과")
    @Test
    void overTryCountTest() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingGame racingGame = new RacingGame(2, numberGenerator, List.of("a"));

        racingGame.moveCars();
        racingGame.moveCars();

        assertThatThrownBy(racingGame::moveCars)
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("이동 값 : 4 이상의 난수 발생 시 움직인다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveCar(int value) {
        NumberGenerator numberGenerator = new StubNumberGenerator(value);
        RacingGame racingGame = new RacingGame(5, numberGenerator, List.of("a"));

        racingGame.moveCars();

        Positions positions = racingGame.getPositions();
        assertThat(positions.getPositionByName("a")).isOne();
    }

    @DisplayName("이동 값 : 4 미만의 난수 발생 시 정지한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopCar(int value) {
        NumberGenerator numberGenerator = new StubNumberGenerator(value);
        RacingGame racingGame = new RacingGame(5, numberGenerator, List.of("a"));

        racingGame.moveCars();

        Positions positions = racingGame.getPositions();
        assertThat(positions.getPositionByName("a")).isZero();
    }

    @DisplayName("각각의 자동차 이동 상황 구현")
    @Test
    void moveOrStopCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingGame racingGame = new RacingGame(5, numberGenerator, List.of("a", "b", "c"));

        racingGame.moveCars();

        Positions positions = racingGame.getPositions();
        assertThat(positions.getPositionByName("a")).isOne();
        assertThat(positions.getPositionByName("b")).isOne();
        assertThat(positions.getPositionByName("c")).isZero();
    }

    @DisplayName("우승자 : 이동거리에 따른 우승자 선정 기능")
    @Test
    void getSoloWinner() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, STOP, STOP,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        racingGame.moveCars();
        racingGame.moveCars();
        racingGame.moveCars();

        List<Car> winners = racingGame.getWinners();
        assertThat(winners)
                .extracting(Car::getName)
                .hasSize(1)
                .contains("a");
    }

    @DisplayName("우승자 : 공동 우승자 발생")
    @Test
    void getCoWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        racingGame.moveCars();
        racingGame.moveCars();
        racingGame.moveCars();

        List<Car> winners = racingGame.getWinners();
        assertThat(winners)
                .hasSize(2)
                .extracting(Car::getName)
                .contains("a", "b");
    }

    @DisplayName("우승자 : 경기 끝나기 전 상황 발생")
    @Test
    void getNotDefinedWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        racingGame.moveCars();

        assertThatThrownBy(racingGame::getWinners)
                .isInstanceOf(IllegalStateException.class);
    }
}