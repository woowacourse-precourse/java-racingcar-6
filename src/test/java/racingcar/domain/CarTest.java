package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {
    @Nested
    @DisplayName("Car 객체 생성: ")
    class createCarBy {
        @Test
        @DisplayName("올바른 입력")
        void validInput() {
            String input = "name";

            Car car = new Car(input);

            assertThat(car).isNotNull();
        }

        @Test
        @DisplayName("5자 초과의 입력")
        void oversizeInput() {
            String input = "invalidInput";

            assertThrows(IllegalArgumentException.class, () -> new Car(input));
        }

        @Test
        @DisplayName("빈 입력")
        void emptyInput() {
            String input = "";

            assertThrows(IllegalArgumentException.class, () -> new Car(input));
        }
    }
}