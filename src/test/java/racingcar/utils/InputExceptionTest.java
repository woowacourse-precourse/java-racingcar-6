package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.PrintMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class InputExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"lion.tiger.bird", "lion/tiger/bird"})
    @DisplayName("자동차 이름 입력 시 콤마 포함 확인 메서드 예외 처리 테스트")
    void isContainCommaTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isContainComma(input);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_SPLIT_COMMA);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "carname", "namename"})
    @DisplayName("자동차 이름이 1자이상 5자이하인지 확인하는 메서드 예외 처리 테스트")
    void validateNameSizeTest(String name) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.validateNameSize(name);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.FIVE_OR_LESS);
    }

    @ParameterizedTest
    @MethodSource("parametersProvider")
    @DisplayName("자동차 이름이 중복되었는지 확인하는 메서드 예외 처리 테스트")
    void validateNameDuplicationTest(List<String> carList) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.validateNameDuplication(carList);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.NOT_DUPLICATE_NAME);
    }

    static Stream<List<String>> parametersProvider() {
        return Stream.of(Arrays.asList("lion", "lion", "bird"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "1zero", "t"})
    @DisplayName("자연수가 맞는지 확인하는 기능 예외 처리 테스트")
    void isNumberTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isNumber(input);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_NATURAL_NUMBER);
    }
}