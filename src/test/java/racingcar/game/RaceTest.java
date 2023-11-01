package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.CarRaceExecutor.updateCarPosition;


class RaceTest {

    private List<Car> carList;

    @BeforeEach
    void setUp() {
        Car pobi = new Car("pobi");
        Car jae = new Car("jae");

        carList = new ArrayList<>();
        carList.add(pobi);
        carList.add(jae);
    }

    @Test
    @DisplayName("레이스를 자동차리스트와 함께 생성한다.")
    void create_race_with_carList() {
        Race race = new Race(carList, 5);
        assertThat(race.getCarList()).isEqualTo(carList);
    }

    @Test
    @DisplayName("레이스 횟수가 양수가 아니면 예외를 던진다.")
    void exception_if_trial_is_not_positive_number() {
        assertThatThrownBy(() -> new Race(carList, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 4이상이면 움직이고 3이하면 멈추는지 확인한다.")
    void whether_car_move() {
        Car car = new Car("yun", () -> 4);
        Car car2 = new Car("jah", () -> 0);
        Race race = new Race(List.of(car, car2), 5);
        race.playMoveOrStop();
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isZero();
    }

    @Test
    @DisplayName("우승자가 한명인 경우, 맞는지 화인한다.")
    void verify_race_winner() {
        Car car = new Car("yun", () -> 4);
        Car car2 = new Car("jah", () -> 0);
        Race race = new Race(List.of(car, car2), 2);
        updateCarPosition(race);

        assertThat(race.getCarNamesWithMaxPosition()).isEqualTo("yun");

    }

    @Test
    @DisplayName("우승자 여러 명일 경우, 맞는지 화인한다.")
    void verify_race_winners() {
        Car car = new Car("yun", () -> 4);
        Car car2 = new Car("jah", () -> 4);
        Race race = new Race(List.of(car, car2), 2);
        updateCarPosition(race);

        assertThat(race.getCarNamesWithMaxPosition()).isEqualTo("yun,jah");

    }


}