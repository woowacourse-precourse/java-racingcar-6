package racingcar.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Cars;
import racingcar.domain.car.TrialCount;
import racingcar.validator.InputValidator;

class InputConverterTest {

    private InputConverter inputConverter;

    @BeforeEach
    void setUp() {
        inputConverter = new InputConverter(new InputValidator());
    }

    @ParameterizedTest
    @DisplayName("사용자 입력 값을 Cars 객체로 생성")
    @ValueSource(strings = {"apple,gogo,wee", "q,www,ee,ttttt", "car1,car2"})
    void should_Convert_String_To_Cars(String input) {
        // when
        Cars cars = inputConverter.toCars(input);

        // then
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수에 대한 사용자 입력 값을 숫자로 변환")
    @ValueSource(strings = {"1", "10", "100", "1000"})
    void should_Convert_String_To_Numeric(String input) {
        // when
        TrialCount trialCount = inputConverter.toTrialCount(input);

        // then
        assertThat(trialCount.getTrialCount()).isEqualTo(Integer.parseInt(input));
    }
}