package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 이동거리가_가장_높은_자동자_목록을_반환한다() {
        // given
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("성겸");
        car1.incrementDistance();
        car1.incrementDistance();

        Car car2 = new Car("성민");
        car2.incrementDistance();
        car2.incrementDistance();

        Car car3 = new Car("성우");
        car3.incrementDistance();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        // when
        List<Car> carsWithHighestDistance = cars.getCarsWithHighestDistance();

        // then
        Assertions.assertThat(carsWithHighestDistance).contains(car1,car2);
    }

    @Test
    void 이동거리가_가장_높은_자동자_목록을_반환한다_빈리스트_반환() {
        // given
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);

        // when
        List<Car> carsWithHighestDistance = cars.getCarsWithHighestDistance();

        // then
        Assertions.assertThat(carsWithHighestDistance).isEmpty();
    }
}