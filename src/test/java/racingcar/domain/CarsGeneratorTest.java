package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsGeneratorTest {

    @Test
    void 주어진_값으로_자동차_생성() {
        String input = "pobi,woni,jun";
        List<Car> cars = CarsGenerator.generateCars(input);
        assertThat(cars).contains(Car.of("pobi"), Car.of("woni"), Car.of("jun"));
        assertThat(cars.size()).isEqualTo(3);
    }
}