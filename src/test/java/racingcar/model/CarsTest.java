package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 실행_결과를_응답한다() {
        String carNames = "pobi";
        Cars cars = new Cars(carNames);
        assertThat(cars.result()).contains("pobi : ");
    }
}