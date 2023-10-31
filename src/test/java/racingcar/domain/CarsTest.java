package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    @DisplayName("자동차 이름 목록을 인자로 받아 자동차 목록을 생성한다.")
    @Test
    void createCarsSuccessTest() {
        // given
        List<String> input = Arrays.asList("pobi", "crong", "honux");

        // when
        Cars cars = new Cars(input);

        // then
        Assertions.assertThat(cars.getSize()).isEqualTo(input.size());
    }

    @DisplayName("자동차 이름 목록이 중복되면 IllegalArgumentException이 발생한다.")
    @Test
    void createCarsExceptionByDuplicateName() {
        // given
        List<String> input = Arrays.asList("pobi", "crong", "pobi");

        // when & then
        Assertions.assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
