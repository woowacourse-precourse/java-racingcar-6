package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarTest {

    @Test
    void 테스트_자동차_전진() {
        // given
        Car car = new Car("Car1");
        // when
        car.moveForward();
        // then
        assertEquals(1, car.getForward());
        assertThat(1).isEqualTo(car.getForward());
    }

    @Test
    void 테스트_자동차_이름() {
        // given
        Car car = new Car("pobi");
        // when
        String name = car.getName();
        // then
        assertEquals(name, car.getName());
        assertThat(name).isEqualTo("pobi");
    }

    @Test
    void 테스트_우승자_이름_리스트() {
        // given
        Car car1 = new Car("pobi");
        car1.moveForward();
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car3.moveForward();

        List<Car> carList = List.of(car1, car2, car3);
        Cars cars = new Cars(carList);
        // when
        List<String> winnerCarNameList = cars.getWinnerCarNameList();

        // then
        assertThat(winnerCarNameList).containsOnly("pobi", "jun");
    }
}
