package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void Cars_Create_테스트() {
        Cars cars = new Cars();
        List<String> list = new ArrayList<>();
        list.add("pobi");
        List<Car> carList = cars.createCars(list);
        assertThat(carList.get(0).getCarName()).isEqualTo("pobi");
        assertThat(carList.get(0).getPosition()).isEqualTo(0);
    }

}