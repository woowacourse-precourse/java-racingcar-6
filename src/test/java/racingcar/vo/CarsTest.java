package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarsTest {
    @Test
    void Cars_생성_성공_테스트() {
        // given
        List<Car> givenCars = List.of(new Car(new CarName("pobi")), new Car(new CarName("woni")));
        // when
        Cars cars = new Cars(givenCars);
        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("Cars 생성 실패 테스트 - 자동차가 2대 미만일 경우")
    void validateMinimumCarsSize() {
        // given
        List<Car> givenCars = List.of(new Car(new CarName("pobi")));
        // when
        // then
        assertThatThrownBy(() -> new Cars(givenCars))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 2대 이상이어야 합니다.");
    }
}