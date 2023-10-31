package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    void 자동차_이름_리스트를_입력받아_자동차_리스트를_반환한다(){
        List<Car> cars = CarFactory.createCars(Arrays.asList("pobi", "crong", "honux"));
        assertThat(cars).isEqualTo(Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux")));
    }
}