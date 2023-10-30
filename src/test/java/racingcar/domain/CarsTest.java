package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void Cars_초기화() {
        cars = new Cars();
    }

    @Test
    void 자동차_추가() {
        // given
        Car car = new Car("pobi");

        // when
        cars.addCar(car);
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList.get(0).getName()).isEqualTo(car.getName());
    }

    @Test
    void 우승자_1명_반환() {
        // given
        Car a = new Car("test1");
        Car b = new Car("test2");
        cars.addCar(a);
        cars.addCar(b);

        // when
        a.go();
        List<String> winner = cars.getWinner();

        // then
        assertThat(winner.size()).isEqualTo(1);
    }

    @Test
    void 우승자_여러명_반환() {
        // given
        Car a = new Car("t1");
        Car b = new Car("t2");
        Car c = new Car("t3");
        cars.addCar(a);
        cars.addCar(b);
        cars.addCar(c);

        // when
        a.go();
        b.go();
        List<String> winner = cars.getWinner();

        // then
        assertThat(winner.size()).isEqualTo(2);
    }
}
