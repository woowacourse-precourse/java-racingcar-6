package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarListGenerator;

import java.util.List;

class CarsTest {

    List<Car> carList;
    Cars cars;

    @BeforeEach
    void beforeEach() {
        String carNames = "car1,car2,car3";
        carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);
    }

    @Test
    void cars_콜렉션_생성() {
        Assertions.assertThat(cars.getClass()).isEqualTo(Cars.class);
        Assertions.assertThat(cars.cars().size()).isEqualTo(3);

        Assertions.assertThat(cars.cars().get(0).getName()).isEqualTo("car1");
        Assertions.assertThat(cars.cars().get(0).getPosition()).isEqualTo(0);
        cars.cars().get(0).forward(1);
        Assertions.assertThat(cars.cars().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void cars_불변_검증_추가시_예외() {
        List<Car> carList = cars.cars();
        Car newCar = new Car("nwCar");
        Assertions.assertThatThrownBy(() -> carList.add(newCar))
                        .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void cars_불변_검증_삭제시_예외() {
        List<Car> carList = cars.cars();
        Assertions.assertThatThrownBy(() -> carList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void cars_불변_검증_초기화시_예외() {
        List<Car> carList = cars.cars();
        Assertions.assertThatThrownBy(carList::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
