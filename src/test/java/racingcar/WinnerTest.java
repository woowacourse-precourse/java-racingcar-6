package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    @Test
    void 우승자_두명_이상_쉼표로_구분() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        // when
        car.movedDistances.replaceAll(empty -> "-");
        StringJoiner winner = Computer.findWinner(car, 1);

        // then
        assertThat(winner.toString()).isEqualTo("pobi, woni, jun");
    }

    @Test
    void 우승자_출력문() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        car.movedDistances.replaceAll(empty -> "-");
        Computer.printWinner(Computer.findWinner(car, 1));

        // then
        assertThat(out.toString())
                .contains("최종 우승자 : pobi, woni, jun");

    }
}
