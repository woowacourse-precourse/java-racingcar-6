package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

//    @BeforeEach
//    void setUp() {
//        Car car = new Car("pobi");
//    }
    
    @DisplayName("자동차 이름이 null, 빈 문자열, 5자 초과인 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", "TooLongName"})
    void nameValidationTest(String inputName) {
        assertThatThrownBy(() -> new Car(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자 이내만 가능합니다.");
    }
}