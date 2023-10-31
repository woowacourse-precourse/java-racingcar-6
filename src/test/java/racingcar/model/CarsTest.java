package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.service.StubMovementStrategy;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUP() {
        Car car1 = new Car("goCar1", 0, new StubMovementStrategy(4));
        Car car2 = new Car("stopCar1", 0, new StubMovementStrategy(3));
        Car car3 = new Car("stopCar2", 0, new StubMovementStrategy(2));
        Car car4 = new Car("goCar2", 0, new StubMovementStrategy(6));

        cars = new Cars(Arrays.asList(car1, car2, car3, car4));
    }

    @Test
    void toList_불변리스트_반환_테스트() {
        List<Car> carList = cars.toList();
        assertThatThrownBy(
            () -> carList.add(new Car("d", 0, new StubMovementStrategy(1)))).isInstanceOf(
            UnsupportedOperationException.class);
    }

    @Test
    void playRound_이동전략에따라_올바르게_움직이는지_테스트() {
        Cars movedCars = cars.playRound();

        assertThat(movedCars.toList().get(0).distance()).isEqualTo(1);
        assertThat(movedCars.toList().get(1).distance()).isEqualTo(0);
        assertThat(movedCars.toList().get(2).distance()).isEqualTo(0);
        assertThat(movedCars.toList().get(3).distance()).isEqualTo(1);
    }

    @Test
    void getMaxDistance_자동차들중_최대거리_반환_테스트() {
        Cars movedCars = cars.playRound();

        assertThat(movedCars.getMaxDistance()).isEqualTo(1);
    }


}