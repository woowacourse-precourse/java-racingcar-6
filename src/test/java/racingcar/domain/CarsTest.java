package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class CarsTest {

    @DisplayName("입력값을 기반으로 자동차를 생성한다.")
    @Test
    void makeCars() {
        // given
        List<String> nameList = List.of("pobi", "lee", "kim");

        // when
        Cars cars = new Cars();
        cars.makeCars(nameList);
        List<Car> carList = cars.getCars();

        // then
        assertThat(carList.size()).isEqualTo(3);
    }

    @DisplayName("getter 호출 시 깊은 복사로 반환한다.")
    @Test
    void getCars() {
        // given
        List<String> nameList = List.of("pobi", "lee", "kim");

        // when
        Cars cars = new Cars();
        cars.makeCars(nameList);
        List<Car> carList = cars.getCars();

        // then
        assertNotSame(cars.getCars(), carList);
    }
}