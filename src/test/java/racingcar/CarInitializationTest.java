package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarInitializationTest {

    @Test
    void initializeCars_ShouldCreateCarsWithValidNames() {
        // 유효한 자동차 이름을 입력하여 자동차 객체를 생성하는 테스트
        List<Car> cars = CarInitialization.initializeCars("pobi,woni,jun");
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void initializeCars_ShouldThrowExceptionForInvalidNames() {
        // 유효하지 않은 자동차 이름을 입력하여 예외가 발생하는 테스트
        assertThatThrownBy(() -> CarInitialization.initializeCars("pobi,woni,javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}