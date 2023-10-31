package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    List<CarName> carNameList;
    CarNames carNames;
    Cars cars;

    @BeforeEach
    void makeCarsObject() {
        carNameList = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));
        carNames = new CarNames(carNameList);
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("이동한 결과를 문자열로 반환")
    void getMoveResultTest() {
        //given
        cars.moveAllCar();

        //when
        String result = cars.getMoveResult();

        //then
        assertThat(result).contains("test1 : ", "test2 : ", "test3 : ");
    }
}
