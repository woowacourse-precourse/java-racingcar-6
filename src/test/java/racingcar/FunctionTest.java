package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_OVERED;
import static racingcar.ExceptionMessage.INPUT_NUMBER_RANGE_MISMATCH;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    @Test
    void Car_생성자로_주어진_값을_구분() {
        String input = "a,b,c";
        Car car = new Car(input);
        int carNumber = car.numberOf();

        List<String> expected = List.of(input.split(","));
        List<String> output = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            output.add(car.name(i));
        }

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
        Car validCar = new Car("a,b");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new RacingCarGameConsole(validCar, timesToTry));
        assertThat(e.getMessage()).isEqualTo(INPUT_NUMBER_RANGE_MISMATCH);
    }
}
