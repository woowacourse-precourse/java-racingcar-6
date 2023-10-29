package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Racing 도메인 테스트")
class RacingTest {

    @Test
    void 사용자가_입력한_이름으로_자동차_생성() {
        // given
        Racing racing = new Racing();
        List<String> carsName = List.of("car A", "car B");

        // when
        racing.generateCars(carsName);

        // then
        List<Car> cars = racing.getCars();
        Assertions.assertAll(
                () -> assertThat(cars).isNotNull(),
                () -> assertThat(cars).hasSize(carsName.size()),
                () -> assertThat(cars.get(0).getName()).isEqualTo(carsName.get(0))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"InvalidCarName", "abcdef"})
    void 자동차_이름_길이_검증(String carName) {
        // given
        Racing racing = new Racing();
        List<String> carsName = List.of(carName);

        // when & then
        assertThatThrownBy(() -> racing.generateCars(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 이동_횟수_검증(int inputMovesNumber) throws Exception {
        // given
        Racing racing = new Racing();

        // when & then
        assertThatThrownBy(() -> racing.updateMovesNumber(inputMovesNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 1회 이상이어야 합니다.");
    }
}