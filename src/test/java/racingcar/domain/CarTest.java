package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    
    @Nested
    @DisplayName("자동차 생성")
    class CreateCar {
        
        @DisplayName("자동차 이름을 올바르게 입력")
        @ParameterizedTest
        @ValueSource(strings = {"poby", "woni", "jun"})
        void string_자동차_이름을_올바르게_입력(String name) {
            assertThatNoException().isThrownBy(()
                    -> new Car(name));
        }
    }
    
    @Nested
    @DisplayName("자동차 이름 예외")
    class ValidateCar {
        
        @Test
        @DisplayName("자동차 이름이 빈 칸이면 예외 발생")
        void blank_자동차_이름이_빈_칸이면_예외_발생() {
            assertThatThrownBy(() -> new Car(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    
        @DisplayName("자동차 이름에 공백이 포함되면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"", "  ", "Hello ys"})
        void blank_자동차_이름에_공백이_포함되면_예외_발생(String name) {
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}