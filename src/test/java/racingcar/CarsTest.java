package racingcar;

import model.Car;
import model.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void 자동차_리스트_생성() {
        Cars cars = new Cars("pobi,woni,hand");
        Assertions.assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차 리스트 이름 테스트")
    void 자동차_리스트_이름_테스트() {
        Cars cars = new Cars("pobi,woni,hand");
        Assertions.assertThat(cars.toString()).isEqualTo("pobi,woni,hand");
    }
}
