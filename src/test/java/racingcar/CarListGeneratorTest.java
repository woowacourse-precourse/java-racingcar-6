package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarListGenerator;

class CarListGeneratorTest {

    @Test
    void getCarList_순서유지_테스트() {
        //given
        List<String> carStrings = Arrays.asList("pobi", "woni", "jun");
        //when
        List<Car> carList = CarListGenerator.getCarList(carStrings);
        //then
        for (int index = 0; index < carStrings.size(); index++) {
            String expectedCarName = carStrings.get(index);
            Car car = carList.get(index);
            String carName = car.getName();
            assertThat(expectedCarName).isEqualTo(carName);
        }
    }
}