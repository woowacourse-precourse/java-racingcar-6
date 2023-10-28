package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 단위 테스")
class CarsTest {

    @DisplayName("정상 상황일 때 Cars가 생성된다.")
    @Test
    void create_cars() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        Cars cars = Cars.from(carNames);

        // then
        assertAll(
                () -> assertThatCode(() -> Cars.from(carNames)).doesNotThrowAnyException(),
                () -> assertThat(cars).isNotNull()
        );
    }

    @DisplayName("중복되는 자동차 이름이 있을 때 예외가 발생한다.")
    @Test
    void throw_exception_when_car_names_duplicate() {
        // given
        List<String> duplicatedCarNames = List.of("pobi", "pobi", "jun");

        // when & then
        assertThatThrownBy(() ->
                Cars.from(duplicatedCarNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 한 대일 때 예외가 발생한다.")
    @Test
    void throw_exception_when_invalid_car_size() {
        // given
        List<String> singleCarNames = Collections.singletonList("pobi");

        // when & then
        assertThatThrownBy(() ->
                Cars.from(singleCarNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 주어지면 자동차를 이동하게 한다.")
    @Test
    void move_cars() {
        // TODO: 테스트 완성
    }

}
