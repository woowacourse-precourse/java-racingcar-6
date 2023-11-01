package mytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import service.InputValidator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @ParameterizedTest
    @MethodSource("invalidList")
    void 자동차이름_5글자이상_예외테스트(final List<String> carListInput) {
        assertThatThrownBy(() -> InputValidator.carListValidate(carListInput.toString()))
                .isInstanceOf(IllegalArgumentException.class);

    }
    private static Stream<Arguments> invalidList() {
        return Stream.of(
                Arguments.arguments(List.of("a,bbbbbb,c")),
                Arguments.arguments(List.of("a,bbbbbb,c,dddddd")),
                Arguments.arguments(List.of("aaaaaa,b,c"))
        );
    }

    @Test
    void 자동차이름_미입력_예외테스트() {
        //given
        String carListInput = "";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carListValidate(carListInput);
        });
    }

    @ParameterizedTest
    @MethodSource("commaInvalidList")
    void 자동차_콤마시작_예외테스트(String carListInput) {
        assertThatThrownBy(() -> InputValidator.carListValidate(carListInput))
                .isInstanceOf(IllegalArgumentException.class);

    }
    private static Stream<Arguments> commaInvalidList() {
        return Stream.of(
                Arguments.arguments(",a,b,c"),
                Arguments.arguments(",a,c"),
                Arguments.arguments(",,a,c"),
                Arguments.arguments(",,a,.,c")
        );
    }


    @ParameterizedTest
    @MethodSource("blankInvalidList")
    void 자동차이름_공백포함_예외테스트(String carListInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.carListValidate(carListInput);
        });
    }

    private static Stream<Arguments> blankInvalidList() {
        return Stream.of(
                Arguments.arguments("a, b, c"),
                Arguments.arguments(" a,b"),
                Arguments.arguments("b,c, ")
        );
    }

    @Test
    void 실행횟수_미입력_예외테스트() {
        //given
        String tryCountInput = "";

        //when,then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.roundInputSetAndValidate(tryCountInput);
        });
    }

    @ParameterizedTest
    @MethodSource("roundInvalidList")
    void 실행횟수_숫자가아닌입력_예외테스트(String userRoundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.roundInputSetAndValidate(userRoundInput);
        });
    }
    private static Stream<Arguments> roundInvalidList() {
        return Stream.of(
                Arguments.arguments("a"),
                Arguments.arguments("b"),
                Arguments.arguments("2!")
        );
    }


    @ParameterizedTest
    @MethodSource("roundBlankInvalidList")
    void 실행횟수_공백포함_예외테스트(String userRoundInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.roundInputSetAndValidate(userRoundInput);
        });
    }
    private static Stream<Arguments> roundBlankInvalidList() {
        return Stream.of(
                Arguments.arguments(" 3"),
                Arguments.arguments("2 "),
                Arguments.arguments(" 123 ")
        );
    }
}
