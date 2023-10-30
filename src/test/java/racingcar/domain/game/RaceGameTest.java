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
    @DisplayName("자동차 수가 지정된 수보다 작으면 예외를 반환한다.")
    void 자동차_수가_지정된_수보다_작으면_예외를_반환한다() {
      // given
      var mockFormula = new MockFormula(MoveState.MOVING_FORWARD);
      var cars = CarFactory.createCars(new ArrayList<>());
      var round = 5;

      // when & then
      assertThatThrownBy(() -> new RaceGame(mockFormula, cars, round))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("자동차는 1대 이상이어야 합니다.");
    }

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
    @DisplayName("MoveState가 MOVING_FORWARD일 때 전진한다.")
    void MoveState가_MOVING_FORWARD일_때_전진한다() {
      // given
      var mockFormula = new MockFormula(MoveState.MOVING_FORWARD);

      // when
      var raceGame = new RaceGame(mockFormula, cars, round);
      var headOfRaceCar = cars.stream()
          .findFirst()
          .orElseThrow();
      var currentPosition = headOfRaceCar.getPosition();
      raceGame.race(raceResults -> {});

      // then
      assertThat(headOfRaceCar.getPosition()).isEqualTo(currentPosition + 1);
    }

    @Test
    @DisplayName("MoveState가 STOP일 때 멈춘다.")
    void MoveState가_STOP일_때_멈춘다() {
      // given
      var mockFormula = new MockFormula(MoveState.STOP);

      // when
      var raceGame = new RaceGame(mockFormula, cars, round);
      var headOfRaceCar = cars.stream()
          .findFirst()
          .orElseThrow();
      var currentPosition = headOfRaceCar.getPosition();
      raceGame.race(raceResults -> {});

      // then
      assertThat(headOfRaceCar.getPosition()).isEqualTo(currentPosition);
    }

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
  }
}
