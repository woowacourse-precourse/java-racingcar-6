package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    void generateParticipationCarListTest() {
        // given
        String input = "pony,zon,brand";

        // when
        List<Car> carList = CarFactory.generateParticipationCarList(input);

        // then
        assertThat(carList).hasSize(3);
        assertThat(carList).extracting(Car::getName).containsExactly("pony", "zon", "brand");
    }
}