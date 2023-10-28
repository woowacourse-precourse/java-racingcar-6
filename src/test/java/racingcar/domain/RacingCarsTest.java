package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("경주 자동차 일급컬렉션의 객체에")
class RacingCarsTest {

    @Nested
    @DisplayName("생성 요청시")
    class CreateValidation {

        @Test
        @DisplayName("요소의 개수가 1개 이하면 예외를 던지는가")
        void oneCar() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new RacingCars(List.of(new RacingCar(new Name("abc")))))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이름이 중복되면 예외를 던지는가")
        void duplicateCar() {
            // given
            // when
            // then
            assertThatThrownBy(
                    () -> new RacingCars(List.of(new RacingCar(new Name("abc")), new RacingCar(new Name("abc")))))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Test
    void numOfElement() {
        // given

        // when

        // then
    }

    @Test
    void moveByNumbers() {
    }

    @Test
    void toResultMessage() {
    }

    @Test
    void findWinners() {
    }
}
