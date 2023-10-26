package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"banana", "apple", "pineapple"})
    @DisplayName("5글자 넘는 이름 설정시 예외 발생하는지")
    public void Car_이름_설정_예외_테스트(String name) {
        //given
        String carName = name;

        //when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 미만이어야 합니다.");
    }
}
