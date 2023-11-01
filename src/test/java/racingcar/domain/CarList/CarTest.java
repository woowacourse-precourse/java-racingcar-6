package racingcar.domain.CarList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.IOTest;

class CarTest extends IOTest {

    private final Car car = new Car("aaa");

    @DisplayName("DTO 생성 테스트")
    @Test
    void createDto() {
        car.createDto();
        assertThat(car.createDto()).isInstanceOf(CarDto.class);
    }
}