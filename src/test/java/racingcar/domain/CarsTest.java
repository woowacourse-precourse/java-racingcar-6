package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
    
    @Nested
    @DisplayName("자동차 이름 목록 생성")
    class CreateCars {
        
        @DisplayName("자동차 이름 목록을 올바르게 입력")
        @ParameterizedTest
        @ValueSource(strings = "poby,woni,jun")
        void string_자동차_이름_목록을_올바르게_입력(String names) {
            assertThatNoException().isThrownBy(()
                    -> new Cars(names));
        }
    }
    
    @Nested
    @DisplayName("자동차 이름 목록 예외")
    class ValidateCars {
        
        @DisplayName("자동차 이름 목록이 빈 칸이면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = "poby,woni,jun")
        void blank_자동차_이름_목록이_빈_칸이면_예외_발생() {
            assertThatThrownBy(() -> new Cars(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    
        @DisplayName("자동차 이름 목록에 유효하지 않은 자동차 이름이 있으면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {", poby", ",", ",,,,,", "poby,,jun", "poby, jun", "poby111,woni"})
        void blank_자동차_이름_목록에_유효하지_않은_자동차_이름이_있으면_예외_발생(String names) {
            assertThatThrownBy(() -> new Cars(names))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}