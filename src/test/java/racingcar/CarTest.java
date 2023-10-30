package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    
    @DisplayName("자동차의 이름은 최소 1자 이상 5자 이하만 가능하다.")
    @Test
    void shouldCarNameLengthBetweenOneAndFive() {
        // given
        String overLengthCarName = "abcdef";
        
        // when // then
        assertThatThrownBy(() -> new Car(overLengthCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name is not valid.");
    }
    
    @DisplayName("자동차의 이름은 빈 문자열이거나 공백만으로 구성될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void shouldNotCarNameBlank(String carName) {
        // when // then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name is not valid.");
    }
}
