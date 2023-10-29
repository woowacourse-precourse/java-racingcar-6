package racingcar.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.game.Cars;

class InputConverterTest {

    private InputConverter inputConverter;

    @BeforeEach
    void setUp() {
        inputConverter = new InputConverter();
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 값을 Cars 객체로 생성")
    @ValueSource(strings = {"apple,gogo,wee", "q,www,ee,ttttt", "car1,car2", "car3"})
    void should_Convert_String_To_Cars(String input) {
        // when
        Cars cars = inputConverter.convertStringToCars(input);

        // then
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수에 대한 사용자 입력 값을 숫자로 변환")
    @ValueSource(strings = {"1", "10", "100", "1000"})
    void should_Convert_String_To_Numeric(String input) {
        // when
        int trial = inputConverter.covertStringToInteger(input);

        // then
        assertEquals(Integer.parseInt(input), trial);
    }
}