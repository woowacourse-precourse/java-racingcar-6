package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATION;
import static racingcar.ExceptionMessage.CAR_NAME_HAS_BLANK;
import static racingcar.ExceptionMessage.CAR_NAME_HAS_NOTHING;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_OVERED;
import static racingcar.ExceptionMessage.INPUT_NUMBER_RANGE_MISMATCH;
import static racingcar.ExceptionMessage.INPUT_TYPE_MISMATCH;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
                Arguments.of("asd, as", CAR_NAME_HAS_BLANK, "공백 포함"),
                Arguments.of("asd,,as", CAR_NAME_HAS_NOTHING, "중간에 없음"),
                Arguments.of(",asd,as", CAR_NAME_HAS_NOTHING, "맨 앞에 없음"),
                Arguments.of("asd,as,", CAR_NAME_HAS_NOTHING, "맨 뒤에 없음"),
                Arguments.of("asd,asdfgh", CAR_NAME_LENGTH_OVERED, "길이 초과"),
                Arguments.of("asd,asdf,asd", CAR_NAME_DUPLICATION, "중복")
        );
    }

    @Test
    void 이동_횟수_형식_오류() {
        String input = "asd";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                InputView::timesToTry);
        assertThat(e.getMessage()).isEqualTo(INPUT_TYPE_MISMATCH);
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
                Arguments.of(-5, INPUT_NUMBER_RANGE_MISMATCH, "음수 입력"),
                Arguments.of(0, INPUT_NUMBER_RANGE_MISMATCH, "0 입력")
        );
    }
}
