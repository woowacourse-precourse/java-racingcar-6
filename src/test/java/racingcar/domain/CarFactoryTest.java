package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarFactoryTest {

    @DisplayName("이름 목록을 인자로 받아 개수만큼 자동차를 생성한다.")
    @Test
    void createCarTest() {
        // given
        CarFactory carFactory = new CarFactory();
        List<String> input = Arrays.asList("pobi", "crong", "honux");
        // when
        List<Car> cars = carFactory.createCars(input);
        // then
        Assertions.assertThat(cars).hasSize(input.size());
        Assertions.assertThat(cars.get(0).getName()).isEqualTo(input.get(0));
        Assertions.assertThat(cars.get(1).getName()).isEqualTo(input.get(1));
        Assertions.assertThat(cars.get(2).getName()).isEqualTo(input.get(2));
    }

    @DisplayName("이름 조건이 맞지 않으면 IllegalArgumentException이 발생한다.")
    @Test
    void createCarTest2() {
        // given
        CarFactory carFactory = new CarFactory();
        List<String> input = List.of("", "abcdef");
        // when & then
        Assertions.assertThatThrownBy(() -> carFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }
}
