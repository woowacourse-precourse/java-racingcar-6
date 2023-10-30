package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void createCarList_메서드로_입력_값을_콤마로_나누어_리스트에_저장() {
        String input = "pobi,woni,jun";
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(input);
        String[] nameArr = carList.stream()
                .map(x -> x.getName())
                .toArray(String[]::new);
        assertThat(nameArr).contains("pobi", "woni", "jun");
    }

    @Test
    void findMaxDistanceCar_메서드로_가장_많은_거리를_이동한_차량_찾기() {
        String input = "pobi,woni,jun";
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(input);
        carList.get(0).moveForward(5);
        carList.get(1).moveForward(3);
        carList.get(2).moveForward(2);
        Car maxDistanceCar = cars.findMaxDistanceCar();
        assertThat(maxDistanceCar.getName()).isEqualTo("pobi");
    }

    @Test
    void findWinner_메서드로_우승자_찾기() {
        String input = "pobi,woni,jun";
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(input);
        carList.get(0).moveForward(4);
        carList.get(1).moveForward(4);
        carList.get(2).moveForward(4);
        List<String> Winners = cars.findWinner();
        System.out.println(Winners);
        assertThat(Winners).contains("pobi", "woni");
        assertThat(Winners).containsExactly("pobi", "woni", "jun");
    }
}