package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATION;
import static racingcar.ExceptionMessage.CAR_NAME_HAS_BLANK;
import static racingcar.ExceptionMessage.CAR_NAME_HAS_NOTHING;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_OVERED;
import static racingcar.ExceptionMessage.INPUT_NUMBER_RANGE_MISMATCH;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    private static final Car VALID_CAR = new Car("a");
    private static final RacingCarGameConsole VALID_RACINGCARGAMECONSOLE
            = new RacingCarGameConsole(VALID_CAR, 1);

    @Test
    void Car_생성자로_주어진_값을_구분() {
        String input = "a,b,c";
        Car car = new Car(input);

        List<String> expected = List.of(input.split(","));
        List<String> output = car.names();

        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index}:{2}")
    @MethodSource("invalidNameParameters")
    void 차_이름_예외_처리(String name, String exceptionMessage, String message) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> invalidNameParameters() {
        return Stream.of(
                Arguments.of("asd, as", CAR_NAME_HAS_BLANK, "공백 포함"),
                Arguments.of("asd,,as", CAR_NAME_HAS_NOTHING, "중간에 없음"),
                Arguments.of(",asd,as", CAR_NAME_HAS_NOTHING, "맨 앞에 없음"),
                Arguments.of("asd,as,", CAR_NAME_HAS_NOTHING, "맨 뒤에 없음"),
                Arguments.of("asd,asdfgh", CAR_NAME_LENGTH_OVERED, "길이 초과"),
                Arguments.of("asd,asdf,asd", CAR_NAME_DUPLICATION, "중복")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0})
    void 이동_횟수가_음수_혹은_0이면_예외_처리(int timesToTry) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new RacingCarGameConsole(VALID_CAR, timesToTry));
        assertThat(e.getMessage()).isEqualTo(INPUT_NUMBER_RANGE_MISMATCH);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void randomNumber에따른_전진_여부_판별(int randomNumber) {
        VALID_RACINGCARGAMECONSOLE.updateCarMovement(randomNumber);

        if (randomNumber < 4) {
            assertThat(0).isEqualTo(VALID_CAR.movedLately(0));
        }
        if (randomNumber >= 4) {
            assertThat(1).isEqualTo(VALID_CAR.movedLately(0));
        }
    }

    @Test
    void 전진한_횟수를_형식에_맞게_출력() {
        String expected = "a : ---";
        String output = VALID_RACINGCARGAMECONSOLE.carMovement(3);

        assertThat(output).isEqualTo(expected);
    }

    @Test
    void 승자를_출력() {
        Car car = new Car("a,b");
        car.move(0);
        OutputView outputView = new OutputView(car);

        String result = outputView.result();

        assertThat(result).isEqualTo("\n최종 우승자 : a");
    }

    @Test
    void 승자를_두명_출력() {
        Car car = new Car("a,b,c");
        car.move(0);
        car.move(1);
        OutputView outputView = new OutputView(car);

        String result = outputView.result();

        assertThat(result).isEqualTo("\n최종 우승자 : a, b");
    }
}
