package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
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
                Arguments.of("asd, as", ExceptionCase.CAR_NAME_HAS_BLANK.message(), "공백 포함"),
                Arguments.of("asd,,as", ExceptionCase.CAR_NAME_HAS_NOTHING.message(), "중간에 없음"),
                Arguments.of(",asd,as", ExceptionCase.CAR_NAME_HAS_NOTHING.message(), "맨 앞에 없음"),
                Arguments.of("asd,as,", ExceptionCase.CAR_NAME_HAS_NOTHING.message(), "맨 뒤에 없음"),
                Arguments.of("asd,asdfgh", ExceptionCase.CAR_NAME_LENGTH_OVERED.message(), "길이 초과"),
                Arguments.of("asd,asdf,asd", ExceptionCase.CAR_NAME_DUPLICATION.message(), "중복")
        );
    }

    @Test
    void 이동_횟수_입력_형식_오류() {
        String input = "asd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                InputView::timesToTry);
        assertThat(e.getMessage()).isEqualTo(ExceptionCase.INPUT_TYPE_MISMATCH.message());
    }

    @ParameterizedTest(name = "{index}:{2}")
    @MethodSource("invalidTimesToTryParameters")
    void 이동_횟수_예외_처리(int timesToTry, String exceptionMessage, String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new RacingCarGameConsole(VALID_CAR, timesToTry));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> invalidTimesToTryParameters() {
        return Stream.of(
                Arguments.of(-5, ExceptionCase.INPUT_NUMBER_RANGE_MISMATCH.message(), "음수 입력"),
                Arguments.of(0, ExceptionCase.INPUT_NUMBER_RANGE_MISMATCH.message(), "0 입력")
        );
    }
}
