package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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
    
    @DisplayName("전진 또는 멈춤 테스트")
    @Nested
    class GoOrStopTest {
        
        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("무작위 값이 4 이상일 경우 전진시킨다. 전진은 `-`를 하나 추가하여 나타낸다.")
        void carGoes(int randomNumber) {
            testCarBehavior(randomNumber, "-");
        }
        
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("생성된 무작위 값이 4 미만일 경우 멈춘다. 멈춤은 그대로인 상태이다.")
        void carStops(int randomNumber) {
            testCarBehavior(randomNumber, "");
        }
        
        private void testCarBehavior(int randomNumber, String expectedMovingDistance) {
            // given
            Car car = new Car("bang");
            
            // when
            car.go(randomNumber);
            
            // then
            assertThat(car.movingDistance).isEqualTo(expectedMovingDistance);
        }
    }
    
    @DisplayName("해당 자동차를 우승자로 변경한다.")
    @Test
    void setWinner() {
        // given
        Car car = new Car("bang");
        
        // when
        car.setWinner();
        
        // then
        assertThat(car.isWinner).isTrue();
    }
}
