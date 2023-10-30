package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars;
    List<Car> carList;

    @BeforeEach
    void setUp() {
        String input = "pobi,woni,jun";
        cars = new Cars();
        carList = cars.createCarList(input);
    }

    @Test
    void createCarList_메서드로_입력_값을_콤마로_나누어_리스트에_저장() {
        setUp();
        String[] nameArr = carList.stream()
                .map(car -> car.getName())
                .toArray(String[]::new);
        assertThat(nameArr).contains("pobi", "woni", "jun");
    }

    @Test
    void findMaxDistanceCar_메서드로_가장_많은_거리를_이동한_차량_찾기() {
        setUp();
        carList.get(0).moveForward(5);
        carList.get(1).moveForward(3);
        carList.get(2).moveForward(2);
        Car maxDistanceCar = cars.findMaxDistanceCar();
        assertThat(maxDistanceCar.getName()).isEqualTo("pobi");
    }

    @Test
    void findWinner_메서드로_우승자_찾기() {
        setUp();
        carList.get(0).moveForward(4);
        carList.get(1).moveForward(4);
        carList.get(2).moveForward(4);
        List<String> Winners = cars.findWinner();
        System.out.println(Winners);
        assertThat(Winners).contains("pobi", "woni");
        assertThat(Winners).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void forceStop_메서드로_예외_발생시키기() {

    }
}