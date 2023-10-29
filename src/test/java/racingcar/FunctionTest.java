package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATION;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_OVERED;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void 차_이름이_길면_예외_발생() {
        String input = "asd,asdfgh";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(input));
        assertThat(e.getMessage()).isEqualTo(CAR_NAME_LENGTH_OVERED);
    }

    @Test
    void 차_이름이_중복이면_예외_발생() {
        String input = "asd,asdf,asd";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(input));
        assertThat(e.getMessage()).isEqualTo(CAR_NAME_DUPLICATION);
    }
}
