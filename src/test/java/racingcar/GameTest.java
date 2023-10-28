package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("각 라운드별 결과값 출력")
    void printResult() {
        // given
        List<Car> cars = new ArrayList<>();
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        cars.add(carA);
        cars.add(carB);

        carA.move();
        carA.move();
        carA.move();
        carB.move();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        Game.printResult(cars);

        // then
        assertThat(out.toString()).isEqualTo("carA : ---\ncarB : -\n\n");
    }
}