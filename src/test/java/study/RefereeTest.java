package study;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Referee;

@DisplayName("심판 객체 기능 테스트")
class RefereeTest {

    @DisplayName("성공: 가장 멀리 이동한 자동차들을 가져올 수 있다.")
    @Test
    void test1() {
        // given
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("wooni");

        cars.add(car1);
        cars.add(car2);

        for (int i = 0; i < 10; i++) {
            cars.forEach(Car::processTurn);
        }

        int furthestDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);
        List<Car> actualFurthestCars = cars.stream()
                .filter(car -> car.getDistance() == furthestDistance)
                .toList();

        // when
        Referee referee = new Referee();
        List<Car> furthestCars = referee.getFurthestCar(cars);

        // then
        assertThat(actualFurthestCars.equals(furthestCars)).isEqualTo(true);
    }
}