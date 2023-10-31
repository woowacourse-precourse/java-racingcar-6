package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.config.GameConfig.MOVEMENT_CONDITION_NUMBER;

@DisplayName("RaceTest")
class RaceTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private List<Car> cars = new ArrayList<>();
    private Race race;

    @BeforeEach
    void init() {
        // given
        car1 = new Car("name1");
        car2 = new Car("name2");
        car3 = new Car("name3");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        race = new Race(cars);
    }

    @Test
    @DisplayName("모든 자동차의 랜덤 숫자가 기준값 이상일 때, 모든 자동차가 이동한다.")
    void moveEachCar() {
        // given
        int randomNumber = MOVEMENT_CONDITION_NUMBER.getNumber() + 1;

        // when
        race.moveEachCar(randomNumber);

        // then
        assertThat(race.getCars()
                        .stream()
                        .map(Car::getDistance)
                        .toList())
                .isEqualTo(List.of(1, 1, 1));
    }

    @Test
    @DisplayName("모든 자동차의 랜덤 숫자가 기준값 이상일 때, 경주 현황을 반환한다.")
    void getStatusString() {
        // given
        int randomNumber = MOVEMENT_CONDITION_NUMBER.getNumber() + 1;

        // when
        race.moveEachCar(randomNumber);
        String statusString = race.getStatusString();

        // then
        assertThat(statusString)
                .isEqualTo(
                        """
                                name1 : -
                                name2 : -
                                name3 : -
                                """);
    }

    @Test
    @DisplayName("모든 자동차의 랜덤 숫자가 기준값 이상일 때, 우승자 목록을 반환한다.")
    void getWinnerString() {
        // given
        int randomNumber = MOVEMENT_CONDITION_NUMBER.getNumber() + 1;

        // when
        race.moveEachCar(randomNumber);
        race.getCars().get(0).move(randomNumber);
        String winnerString = race.getWinnerString();

        // then
        assertThat(winnerString)
                .isEqualTo("name1");
    }

    @Test
    @DisplayName("자동차 목록을 반환한다.")
    void getCars() {
        // when
        List<Car> getCars = race.getCars();

        // then
        assertThat(cars).isEqualTo(getCars);
    }
}