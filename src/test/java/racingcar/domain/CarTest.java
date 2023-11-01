package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Nested
    @DisplayName("정상 작동 테스트")
    class NormalTests {

        @Test
        @DisplayName("Car 생성 테스트")
        void testCarCreate() {
            Car car = new Car("12345");
            assertThat(car.getName()).isEqualTo("12345");
            assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("Car 전진 테스트")
        void testMoveForward() {
            Car car = new Car("Test");
            car.moveForward();
            car.moveForward();
            assertThat(car.getPosition()).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("exception 테스트")
    class ExceptionTests {

        @Test
        @DisplayName("car 이름이 Null")
        void testNameIsNull() {
            assertThatThrownBy(() -> new Car(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름 null 불가");
        }

        @Test
        @DisplayName("car 이름이 공백")
        void testNameIsBlank() {
            assertThatThrownBy(() -> new Car(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름 공백 불가");
        }

        @Test
        @DisplayName("자동차 이름 입력 범위 테스트")
        void testNameExceedsMaxLength() {
            assertThatThrownBy(() -> new Car("123456"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름 글자 범위 초과");
        }

        @Test
        @DisplayName("허용하지 않은 자동차 이름 테스트")
        void testNameWithInvalidCharacters() {
            assertThatThrownBy(() -> new Car("아아아"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 문자와 숫자만 가능");
        }

        @Test
        @DisplayName("자동차 이름에 , 만 있는 경우 테스트")
        void testNameIsCommas() {
            assertThatThrownBy(() -> new Car(" ,, "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 문자와 숫자만 가능");
        }
    }
}
