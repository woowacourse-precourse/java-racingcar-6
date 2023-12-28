package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.formula.MockFormula;
import racingcar.domain.formula.MoveState;

public class RaceGameTest {

    @Nested
    @DisplayName("게임을 시작할 때")
    public class StartGameTest {

        @Test
        @DisplayName("시도 회수가 1보다 작으면 예외를 반환한다.")
        void 시도_회수가_1보다_작으면_예외를_반환한다() {
            // given
            var mockFormula = new MockFormula(MoveState.MOVING_FORWARD);
            var cars = CarFactory.createCars(List.of("pobi", "crong", "honux"));
            var round = 0;

            // when & then
            assertThatThrownBy(() -> new RaceGame(mockFormula, cars, round))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도할 회수는 1 이상이어야 합니다.");
        }
    }

    @Nested
    @DisplayName("게임을 진행할 때")
    public class WhileGameTest {

        private final List<Car> cars = CarFactory.createCars(List.of("pobi", "crong", "honux"));
        private final int round = 1;

        @Test
        @DisplayName("현재 가장 멀리 이동한 자동차의 이름을 반환한다.")
        void 현재_가장_멀리_이동한_자동차의_이름을_반환한다() {
            // given
            var mockFormula = new MockFormula(MoveState.MOVING_FORWARD);

            // when
            var raceGame = new RaceGame(mockFormula, cars, round);
            var headOfRaceCar = cars.stream()
                    .findFirst()
                    .orElseThrow();
            var otherCars = cars.stream()
                    .filter(car -> cars.indexOf(car) != cars.indexOf(headOfRaceCar))
                    .toList();
            headOfRaceCar.move(mockFormula);

            // then
            assertThat(raceGame.currentHeadOfRace())
                    .containsExactly(headOfRaceCar.getName())
                    .doesNotContainAnyElementsOf(otherCars.stream().map(Car::getName).toList());
        }

        @Test
        @DisplayName("자동차 목록이 비어있으면 예외를 반환한다.")
        void 자동차_목록이_비어있으면_예외를_반환한다() {
            // given
            var mockFormula = new MockFormula(MoveState.MOVING_FORWARD);
            var emptyCars = new ArrayList<Car>();
            var round = 1;

            // when & then
            var raceGame = new RaceGame(mockFormula, emptyCars, round);
            assertThatThrownBy(raceGame::currentHeadOfRace)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 목록이 비어있습니다.");
        }
    }
}
