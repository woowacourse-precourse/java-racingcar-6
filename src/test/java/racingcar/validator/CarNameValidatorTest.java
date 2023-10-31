package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

class CarNameValidatorTest {

    @DisplayName("아무런 값을 입력하지 않았을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NULL_ERROR.getMessage(), exception.getMessage());
    }

    @DisplayName("구분자는 쉼표만 사용 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"zebi-hong", "go.tan.ron"})
    void validateSeparator(String input) {
        // when
        Throwable exception = getException(input);
        // then
        assertEquals(ErrorMessage.ONLY_COMMA.getMessage(), exception.getMessage());
    }

    @DisplayName("마지막을 쉼표로 끝낼 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,", "a,b,", ",,,"})
    void validateEndWithComma(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NOT_ALLOW_END_WITH_COMMA.getMessage(), exception.getMessage());
    }

    @DisplayName("이름은 1 ~ 5 글자로 입력해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"colacola,pong", "p,brand2"})
    void validateCarNameLength(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NAME_BETWEEN_ONE_AND_FIVE.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름은 영소문자, 숫자, 한글, 이름 사이에 공백만 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"c@3,Ad+", "c-22,go@naver", "ㅁㄴㅇㄹ,pony"})
    void validateCarNameCond(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.CAR_NAME_COND.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름의 시작에 공백을 넣을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"a, b", " a,b"})
    void validateIsStartBlank(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NOT_ALLOW_BLANK_IN_START.getMessage(), exception.getMessage());
    }

    @DisplayName("자동차 이름의 마지막에 공백을 넣을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"a ,b", "a,b "})
    void validateIsEndBlank(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NOT_ALLOW_BLANK_IN_END.getMessage(), exception.getMessage());
    }

    @DisplayName("중복된 이름을 입력할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"pony,zon,pony", "abc,abc"})
    void validateDuplication(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NOT_ALLOW_NAME_DUPLICATION.getMessage(), exception.getMessage());
    }

    private Throwable getException(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validate(input);
        });
    }
}