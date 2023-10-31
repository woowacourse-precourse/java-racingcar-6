package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.power.DefaultPowerGenerator;

@DisplayName("심판 테스트")
class RefereeTest {

    @DisplayName("단일 우승자를 올바르게 가려낸다")
    @Test
    void testSelectWinnersWithSingleWinner() {
        Car car1 = new Car("car1", 3, new DefaultPowerGenerator());
        Car car2 = new Car("car2", 5, new DefaultPowerGenerator());
        Car car3 = new Car("car3", 2, new DefaultPowerGenerator());
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Referee referee = new Referee();
        List<Car> winners = referee.selectWinners(cars);
        Assertions.assertThat(winners).containsExactly(car2);
    }

    @DisplayName("복수 우승자를 올바르게 가려낸다")
    @Test
    void testSelectWinnersWithMultipleWinner() {
        Car car1 = new Car("car1", 3, new DefaultPowerGenerator());
        Car car2 = new Car("car2", 5, new DefaultPowerGenerator());
        Car car3 = new Car("car3", 5, new DefaultPowerGenerator());
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Referee referee = new Referee();
        List<Car> winners = referee.selectWinners(cars);
        Assertions.assertThat(winners).containsExactly(car2, car3);
    }
}