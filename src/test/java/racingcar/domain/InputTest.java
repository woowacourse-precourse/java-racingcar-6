package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.domain.ExceptionCase.CAR_NAME_DUPLICATION;
import static racingcar.domain.ExceptionCase.CAR_NAME_HAS_BLANK;
import static racingcar.domain.ExceptionCase.CAR_NAME_LENGTH_OVERED;
import static racingcar.domain.ExceptionCase.INPUT_UNGIVEN;
import static racingcar.domain.ExceptionCase.TIMES_TO_TRY_TYPE_MISMATCH;
import static racingcar.domain.ExceptionCase.UNNAMED_CAR_EXIST;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputTest {
    private final static String VALID_CAR_NAMES = "a,b,c";
    private final static Car VALID_CAR = new Car(VALID_CAR_NAMES);

    @Test
    void 차_이름_분할() {
        List<String> expected = List.of(VALID_CAR_NAMES.split(","));
        List<String> output = VALID_CAR.names();

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index}:{2}")
    @MethodSource("invalidCarNamesParameters")
    void 차_이름_예외_처리(String carNames, String exceptionMessage, String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Car(carNames));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> invalidCarNamesParameters() {
        return Stream.of(
                Arguments.of("", INPUT_UNGIVEN.message(), "입력 없음"),
                Arguments.of("asd, as", CAR_NAME_HAS_BLANK.message(), "공백 포함"),
                Arguments.of("asd,,as", UNNAMED_CAR_EXIST.message(), "중간에 없음"),
                Arguments.of(",asd,as", UNNAMED_CAR_EXIST.message(), "맨 앞에 없음"),
                Arguments.of("asd,as,", UNNAMED_CAR_EXIST.message(), "맨 뒤에 없음"),
                Arguments.of("asd,asdfgh", CAR_NAME_LENGTH_OVERED.message(), "길이 초과"),
                Arguments.of("asd,asdf,asd", CAR_NAME_DUPLICATION.message(), "중복")
        );
    }

    @ParameterizedTest(name = "{index}:{2}")
    @MethodSource("invalidTimesToTryParameters")
    void 이동_횟수_예외_처리(String timesToTry, String exceptionMessage, String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new GameConsole(VALID_CAR, timesToTry));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> invalidTimesToTryParameters() {
        return Stream.of(
                Arguments.of("", INPUT_UNGIVEN.message(), "입력 없음"),
                Arguments.of("asd", TIMES_TO_TRY_TYPE_MISMATCH.message(), "정수가 아닌 입력"),
                Arguments.of("-5", TIMES_TO_TRY_TYPE_MISMATCH.message(), "음수 입력"),
                Arguments.of("0", TIMES_TO_TRY_TYPE_MISMATCH.message(), "0 입력")
        );
    }
}
