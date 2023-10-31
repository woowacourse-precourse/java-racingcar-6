package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.model.exception.ExceptionMessage.DUPLICATE_CAR_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("쉼표를 기준으로 자동차가 생성된다.")
    void playCarsSizeTest() {
        // given & when
        Cars cars = Cars.from("john,bob,alice");
        List<Car> playCars = cars.getCars();

        // then
        assertThat(playCars.size()).isEqualTo(3);
    }

    @Nested
    @DisplayName("자동차 이름 독립/중복 테스트")
    class DuplicateCarsTest {

        @Test
        @DisplayName("자동차 이름이 모두 독립적이면 정상 생성된다.")
        void createCarsTest() {
            // when & then
            assertDoesNotThrow(() -> Cars.from("john,bob,alice"));
        }

        @Test
        @DisplayName("같은 이름을 가진 자동차가 있으면 예외가 발생한다.")
        void duplicateNameCarsExceptionTest() {
            // when & then
            assertThatThrownBy(() -> Cars.from("john,john,bob")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_CAR_EXCEPTION.getMessage());
        }
    }
}
