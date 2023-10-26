package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ViewTest {

    @Test
    void showResult() {
        // given
        View view = new View();
        List<Car> case1 = List.of(new Car("car1"));
        List<Car> case2 = List.of(new Car("car1"), new Car("car2"));

        // when
        OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        view.showResult(case1);
        OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        view.showResult(case2);

        // then
        assertThat(result1.toString().strip()).as("1 winner").isEqualTo("car1");
        assertThat(result2.toString().strip()).as("2 winner").isEqualTo("car1, car2");
    }
}