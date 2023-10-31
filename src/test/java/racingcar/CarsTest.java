package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 객체_숫자_전달() {
        Car car = new Car("자동차");
        Cars cars = new Cars(List.of(car));
        cars.move();

        assertThat(car.indicate()).isEqualTo("자동차 : -");
    }

    @Test
    void 객체_결과_출력() {
        List<String> names = DataTypeChanger.stringToList("123,234,345,456");
        List<Car> carNames = DataTypeChanger.stringToCar(names);
        Cars cars = new Cars(carNames);
        cars.move();

        cars.move();

        assertThatCode(() -> SystemOutput.printResult(cars.indicate())).doesNotThrowAnyException();
    }
}
