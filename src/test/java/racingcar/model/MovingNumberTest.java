package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovingNumberTest {
    MovingNumber movingNumber;

    @Test
    @DisplayName("입력한 정수에 대한 결과 확인")
    void createMovingNumberTest() {
        movingNumber = MovingNumber.createMovingNumber("3");
        assertThat(movingNumber.getNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("빈 문자열에 대한 예외 처리 확인")
    void EmptyStringTest() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수로 변환할 수 없는 문자열에 대한 예외 처리 확인")
    void NotIntegerTest() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수로 변환할 수 없는 문자열에 대한 예외 처리 확인 2")
    void NotIntegerTest2() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("3.1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수로 변환할 수 없는 문자열에 대한 예외 처리 확인 3")
    void NotIntegerTest3() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("3.0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수로 변환할 수 없는 문자열에 대한 예외 처리 확인 4")
    void NotIntegerTest4() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("0.0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양의 정수로 변환할 수 없는 문자열에 대한 예외 처리 확인")
    void NotPositiveIntegerTest() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("-2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양의 정수로 변환할 수 없는 문자열에 대한 예외 처리 확인 2")
    void NotPositiveIntegerTest2() {
        assertThatThrownBy(() -> {
            movingNumber = MovingNumber.createMovingNumber("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
