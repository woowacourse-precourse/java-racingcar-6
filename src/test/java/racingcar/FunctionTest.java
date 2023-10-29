package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_OVERED;
import static racingcar.ExceptionMessage.INPUT_NUMBER_RANGE_MISMATCH;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @Test
    void 차_이름이_길면_예외_처리() {
        String input = "asd,asdfgh";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(input));
        assertThat(e.getMessage()).isEqualTo(CAR_NAME_LENGTH_OVERED);
    }

    @Test
    void 차_이름이_중복이면_예외_처리() {
        String input = "asd,asdf,asd";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(input));
        assertThat(e.getMessage()).isEqualTo(CAR_NAME_DUPLICATION);
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
}
