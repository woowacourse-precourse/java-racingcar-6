package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    
    private Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car("bang");
    }
    
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
        @DisplayName("무작위 값이 4 이상일 경우 전진시킨다.")
        void carGoes(int randomNumber) {
            testCarBehavior(randomNumber, 1);
        }
        
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("생성된 무작위 값이 4 미만일 경우 멈춘다. 멈춤은 그대로인 상태이다.")
        void carStops(int randomNumber) {
            testCarBehavior(randomNumber, 0);
        }
        
        private void testCarBehavior(int randomNumber, int expectedLocation) {
            // when
            car.go(randomNumber);
            
            // then
            assertThat(car.location).isEqualTo(expectedLocation);
        }
    }
    
    @DisplayName("해당 자동차를 우승자로 변경한다.")
    @Test
    void setWinner() {
        // when
        car.setWinner();
        
        // then
        assertThat(car.isWinner).isTrue();
    }
    
    @DisplayName("Car 인스턴스가 생성될 때, 유효한 이름이면 이름이 설정되고, location 값은 0, isWinner 값은 false로 초기화된다.")
    @Test
    void newCarSetRightInitialVariables() {
        // then
        assertThat(car)
                .extracting("name", "location", "isWinner")
                .containsExactly("bang", 0, false);
    }
    
    @DisplayName("Car의 위치 상태를 불러오면 전진된 location만큼 \"-\"가 반복된 문자열을 가져온다.")
    @Test
    void specificStringRepeatsSeveralTimes() {
        // given
        String expectedLocationStatus = "-----";
        goFiveTimes();
        
        // when
        String resultLocationStatus = car.getLocationStatus();
        
        // then
        assertThat(resultLocationStatus).isEqualTo(expectedLocationStatus);
    }
    
    private void goFiveTimes() {
        for (int i = 0; i < 5; i++) {
            car.go(5);
        }
    }
}
