package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.error.ErrorMessage.LONG_CAR_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car danaka;
    private int expectForwardCount;

    @BeforeEach
    void setUp() {
        expectForwardCount = 3;
        danaka = new Car("다나카", expectForwardCount);
    }

    @Test
    @DisplayName("5글자 이하인 이름으로 자동차 객체를 생성한다.")
    void instance_WithLessThanFiveCharacters_Success() {
        // Given
        String name = "tayo";

        // When
        Car result = new Car(name);

        // Then
        assertThat(result.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("5글자 초과인 이름으로 자동차 객체 생성 시 실패한다.")
    void instance_WithMoreThanFiveCharacters_Fail() {
        // Given
        String name = "abcdef";

        // When & Then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LONG_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("4 이상인 값일 때 자동차가 전진한다.")
    void forward_GreaterThanFour_Forward() {
        // Given
        int value = 4;

        // When
        danaka.forward(value);

        // Then
        int result = danaka.getForwardCount();

        assertThat(result).isEqualTo(expectForwardCount + 1);
    }

    @Test
    @DisplayName("4 미만인 값일 때 자동차는 멈춘다.")
    void forward_LessThanFour_Stop() {
        // Given
        int value = 3;

        // When
        danaka.forward(value);

        // Then
        int result = danaka.getForwardCount();

        assertThat(result).isEqualTo(expectForwardCount);
    }

}