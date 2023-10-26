package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.error.ErrorMessage.LONG_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

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

}