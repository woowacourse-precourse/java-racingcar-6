package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("자동차 여러대 리스트 만들기 성공")
    void createCars_성공() {
        List<String> strings = List.of("pobi","woni","jun");
        Cars cars = new Cars(strings);
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차 한대 만들기 성공")
    void createCar_성공() {
        String name = "pobi";
        Car car = new Car(name);
        assertThat(car).isNotNull();
    }
}