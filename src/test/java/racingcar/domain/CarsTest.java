package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 입력_값을_콤마로_나누어_리스트에_저장() {
        String input = "pobi,woni,jun";
        Cars cars = new Cars();
        List<Car> carList = cars.createCarList(input);
        String[] nameArr = carList.stream()
                .map(x -> x.getName())
                .toArray(String[]::new);
        assertThat(nameArr).contains("pobi", "woni", "jun");
    }
}