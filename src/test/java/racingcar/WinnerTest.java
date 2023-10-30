package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    void 우승자_한명() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        // when
        car.movedDistances.set(0, "-");
        StringJoiner winner = Computer.findWinner(car, 1);

        // then
        assertThat(winner.toString()).isEqualTo("pobi");
    }
}
