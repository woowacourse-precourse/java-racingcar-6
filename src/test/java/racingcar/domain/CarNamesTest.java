package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarNamesTest {

    @Test
    @DisplayName("메소드 사용시 CarName들이 각 Car에 등록")
    void assignNamesToCarsTest() {
        //given
        List<CarName> carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        CarNames carNames = new CarNames(carNameList);

        //when
        List<Car> cars = carNames.assignNamesToCars();

        //then
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }
}