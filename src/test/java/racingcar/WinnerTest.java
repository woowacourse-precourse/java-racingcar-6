package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constants.Message.RESULT;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    void 최대_주행거리_찾기() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));
        car.movedDistances.set(0, "-");
        car.movedDistances.set(1, "-");

        // when
        int maxDistance = CarRace.findBest(car.movedDistances);

        // then
        assertThat(maxDistance).isEqualTo(1);

    }

    @Test
    void 우승자_한명() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));
        car.movedDistances.set(0, "-");

        // when
        StringJoiner winner = CarRace.findWinner(car, CarRace.findBest(car.movedDistances));

        // then
        assertThat(winner.toString()).isEqualTo("pobi");
    }

    @Test
    void 우승자_두명_이상_쉼표로_구분() {

        // given
        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));
        car.movedDistances.replaceAll(empty -> "-");

        // when
        StringJoiner winner = CarRace.findWinner(car, CarRace.findBest(car.movedDistances));

        // then
        assertThat(winner.toString()).isEqualTo("pobi, woni, jun");
    }

    @Test
    void 우승자_출력문() {

        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car = new Car(Arrays.asList("pobi", "woni", "jun"));
        car.movedDistances.replaceAll(empty -> "-");

        // when
        CarRace.printWinner(CarRace.findWinner(car, 1));

        // then
        assertThat(out.toString())
                .contains(RESULT.getMessage() + "pobi, woni, jun");

    }
}
