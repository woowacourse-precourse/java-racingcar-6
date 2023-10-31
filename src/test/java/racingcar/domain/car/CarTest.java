package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 생성자의 1~5자의 문자열이 주어진 경우 인스턴스를 생성한다.")
    @Test
    void givenCorrectString_WhenNew_ThenReturnInstance() {
        // Given
        String name = "정상이름";

        // When
        Car actual = new Car(name);
        Car expected = new Car(name);

        // Then
        assertAll(
                () -> assertInstanceOf(Car.class, actual),
                () -> assertEquals(name, actual.getName()),
                () -> assertEquals(expected, actual),
                () -> assertNotSame(expected, actual)
        );
    }

    @DisplayName("자동차 생성자의 인자로 5자 이상의 문자열이 주어진 경우 예외를 발생한다.")
    @Test
    void givenUpperFiveLengthString_WhenNew_ThenThrowException() {
        // Given
        String name = "5자이상이름";

        // When
        // Then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 5자 까지만 허용됨");
    }

    @DisplayName("자동차 생성자의 인자로 빈 문자열이 주어진 경우 예외를 발생한다.")
    @Test
    void givenEmptyString_WhenNew_ThenThrowException() {
        // Given
        String name = "";

        // When
        // Then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름은 비어있을 수 없음");
    }

    @DisplayName("4이상의 숫자가 주어지면 위치를 1증가한다.")
    @Test
    void givenUpperFourNumber_WhenTryToMove_ThenIncreasePosition() {
        // Given
        Car move = new Car("move");
        Car car = new Car("car");
        int number = 5;

        // When
        move.tryToMove(number);

        // Then
        assertAll(
                () -> assertFalse(move.isSamePosition(car)),
                () -> assertEquals(1, move.compareTo(car))
        );
    }
}