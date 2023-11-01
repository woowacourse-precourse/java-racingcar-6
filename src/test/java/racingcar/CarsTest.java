package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.DataTypeChanger;
import racingcar.view.SystemOutput;

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

    @Test
    void 객체_비교_테스트() {
        List<String> names = DataTypeChanger.stringToList("123,234");
        List<Car> carNames = DataTypeChanger.stringToCar(names);
        carNames.get(0).movable(4);
        Cars cars = new Cars(carNames);
        assertThat(cars.indicate().toString()).isEqualTo("[123 : -, 234 : ]");
        assertThat(cars.compare(carNames.get(0))).isEqualTo(0);
    }
    @Test
    void 객체_비교_테스트_무승부() {
        List<String> names = DataTypeChanger.stringToList("123,234");
        List<Car> carNames = DataTypeChanger.stringToCar(names);
        carNames.get(0).movable(4);
        carNames.get(1).movable(4);
        Cars cars = new Cars(carNames);
        assertThat(cars.indicate().toString()).isEqualTo("[123 : -, 234 : -]");
        assertThat(cars.compare(carNames.get(0))).isEqualTo(0);
    }
}
