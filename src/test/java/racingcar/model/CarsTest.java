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

    @Test
    void Cars_GetFinalWinner_최종_우승_반환_테스트() {
        Cars cars = new Cars();
        List<String> list = new ArrayList<>();
        list.add("pobi");
        list.add("woni");
        list.add("jun");
        cars.createCars(list);
        assertThat(cars.getFinalWinner()).contains("pobi","woni","jun");

    }

}