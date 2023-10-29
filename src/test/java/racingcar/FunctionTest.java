package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

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
}
