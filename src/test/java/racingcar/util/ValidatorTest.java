package racingcar.util;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }

    @ParameterizedTest
    @DisplayName("이름 6자 이상 입력 예외 테스트")
    @ValueSource(strings = {"gildong", "홍2동1동길", "monster", " d wd d2w w  "})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isLengthLessThanFive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    private static Stream<Arguments> provideDuplicateTestCases() {
        return Stream.of(Arguments.of((Object) new String[]{"pobi", "pobi", "pobi"}),
                Arguments.of((Object) new String[]{"woni", "pobi", "woni"}),
                Arguments.of((Object) new String[]{"jun", "woni", "jun"}),
                Arguments.of((Object) new String[]{"woni", "jun", "jun"}));
    }

    @ParameterizedTest
    @DisplayName("중복된 자동차 이름을 입력 예외 테스트")
    @MethodSource("provideDuplicateTestCases")
    public void invalidInputsTest3(String[] inputs) {
        Assertions.assertThatThrownBy(() -> Validator.isDuplicateName(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않는 자동차 이름을 입력해주세요.");
    }

    private static Stream<Arguments> provideValidTestCases() {
        return Stream.of(Arguments.of((Object) new String[]{"1", "2", "3"}),
                Arguments.of((Object) new String[]{"woni", "pobi", "jun"}),
                Arguments.of((Object) new String[]{"pobhi", "javji", "1w"}),
                Arguments.of((Object) new String[]{"4ewr", "2qwe", "jpun"}));
    }

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름 입력 모든 유효성 성공 테스트")
    @MethodSource("provideValidTestCases")
    void validInputsTest(String[] inputs) {
        Assertions.assertThatCode(() -> Validator.isValidName(inputs))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("1미만의 수를 입력 예외 테스트")
    @ValueSource(strings = {"0", "-151", "00", "000", "01", "-1"})
    void invalidInputsTest4(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isOneOrMore(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 숫자만 가능합니다.");
    }
}