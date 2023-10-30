package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorMessage;
import racingcar.utils.Converter;
import racingcar.utils.Validator;

public class InputTest {
    @Test
    @DisplayName("사용자 입력이 콤마(,)를 기준으로 나뉘어지는가?")
    void testStoreCarNames() {
        String input = "pobi,jun";
        List<String> names = Converter.convertStringToList(input);

        assertThat(names).isEqualTo(List.of("pobi", "jun"));
    }

    @Test
    @DisplayName("자동차 명이 5글자 초과일 경우, 에러 문구를 발생하는가?")
    void testErrorNot5CharLess() {
        String input = "pobi,javaji";

        List<String> names = Converter.convertStringToList(input);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.validateCarName(names));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.ERROR_NAME_MUST_BE_5_CHARACTERS_LESS.getMessage());
    }


    @Test
    @DisplayName("사용자의 입력이 숫자로 변경 되는가?")
    void testConvertToInt() {
        String input = "4";

        assertThat(Converter.convertStringToInt(input)).isEqualTo(4);
    }

    @Test
    @DisplayName("사죵자의 입력이 숫자가 아닐때, 에러를 출력하는가?")
    void testErrorConvertToInt() {
        String input = "다섯번";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.validateNumber(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.ERROR_NAME_MUST_BE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사죵자의 입력이 숫자가 아닐때, 에러를 출력하는가? - 공백")
    void input_숫자가_아닌_공백() {
        String input = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.validateNumber(input));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.ERROR_NAME_MUST_BE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사용자의 입력이 중복이 된 경우, 에러를 출력하는가?")
    void testErrorNameDuplicated() {
        String input = "pobi,pobi";

        List<String> names = Converter.convertStringToList(input);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.validateNotDuplicate(names));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.ERROR_NAME_MUST_BE_NOT_DUPLICATED.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {",java,jigi", "java,,jigi", "java, ,jigi", " ,java,jigi"})
    @DisplayName("사용자의 입력에 공백이 있는 경우, 에러를 출력하는가?")
    void input_자동차_이름_공백_테스트(String input) {
        List<String> names = Converter.convertStringToList(input);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Validator.validateNoSpace(names));

        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.ERROR_NAME_MUST_NO_SPACE.getMessage());
    }
}
