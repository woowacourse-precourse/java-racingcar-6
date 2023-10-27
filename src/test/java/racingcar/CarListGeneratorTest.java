package racingcar;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarListGenerator;

class CarListGeneratorTest {

    @Test
    void getCarList() {
        //given
        List<String> carsString = Arrays.asList("pobi", "woni", "jun");
        //when
        //then
        assertThat(CarListGenerator.getCarList(carsString).get(0)).isInstanceOf(Car.class);
    }
}