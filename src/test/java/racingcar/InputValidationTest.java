package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni/jun", "pobi,woni jun", "pobi,woni.jun", "pobi-woni,jun", "pobi_woni,jun"})
    void 구분자에_대한_예외_처리(String name) {
        assertThatThrownBy(() -> inputValidation.validateInputCorrectSeparator(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputOutOfLengthName")
    void 자동차_이름_길이에_대한_예외_처리(String[] names) {
        assertThatThrownBy(() -> inputValidation.validateNameOfCarsLength(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_중복에_대한_예외_처리() {
        assertThatThrownBy(() -> inputValidation.validateDuplicateName(new String[]{"pobi", "pobi", "jun"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101, 77775555})
    void 이동_횟수에_대한_예외_처리(int count) {
        assertThatThrownBy(() -> inputValidation.validateMoveCountRange(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> inputOutOfLengthName() {
        return Stream.of(
                Arguments.of((Object) new String[]{"cheonwoo", "pobi", "woni"}),
                Arguments.of((Object) new String[]{"", "pobi", "woni"})
        );
    }
}