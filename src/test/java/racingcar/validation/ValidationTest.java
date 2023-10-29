package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationTest {

    @Test
    @DisplayName("vali 1 - 자동차 이름이 5자 이하가 맞는지 체크 (6자리 이상인지 체크)")
    public void validCarName() {
        //given
        String correctCarName = "MyCar";

        //when

        // then
        assertDoesNotThrow(() -> Validation.valiCarName(correctCarName));
    }

    @Test
    @DisplayName("vali 4 - (쉼표),구분자로 구분한 자동차 이름(문자열)이 빈 문자열이 아닌지 검사")
    public void invalidEmptyCarName() {
        //given
        String emptyCarName = "";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> Validation.valiCarName(emptyCarName));
    }

    @Test
    @DisplayName("자동차 이름이 6자리 이상일 경우")
    public void invalidCarNameLength() {
        //given
        String invalidLengthCarName = "carName";
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> Validation.valiCarName(invalidLengthCarName));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            ",,",
            ",",
    })
    @DisplayName("vali 3 - ,(쉼표) 구분자로 나눠서 반환된 문자열 배열이 비었는지 체크")
    public void invaliEmptySplitInputCarNames(String invalidInput) {
        //given
        String input = invalidInput;
        String[] split = input.split(",");
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> Validation.valiEmptySplitInputCarNames(split));
    }
}
