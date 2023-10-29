package validatorTest;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.validator.CarNameRegexValidator;

public class CarNameRegexTest {

    @ParameterizedTest
    @DisplayName("잘못된 자동차 이름 검증")
    @ValueSource(strings = {"!@#$%","pobi;;00hooni___","123$%^&"})
    void CarNameWrongValueTest(String value){
        //when
        boolean result = CarNameRegexValidator.isCharsOrComma(value);

        //then
        assertThat(result).isFalse();

    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 검증")
    @ValueSource(strings = {"test","pobi,hooni","racingCar1,racingCar2,racingCar3"})
    void CarNameRightValueTest(String value){
        //when
        boolean result = CarNameRegexValidator.isCharsOrComma(value);

        //then
        assertThat(result).isTrue();

    }

}
