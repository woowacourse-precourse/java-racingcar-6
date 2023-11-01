package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRacingTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 전체_3턴_레이스_전진() {
        List<String> inputCars = Arrays.asList("a", "b");
        CarRacing carRacing = new CarRacing(inputCars, ((low, high) -> 4)); // 랜덤값 -> 항상 4
        int turn = 3;

        carRacing.race(turn);

        assertThat(outputStream.toString()).contains("a : ---").contains("b : ---");
    }

    @Test
    void 전체_3턴_레이스_멈춤() {
        List<String> inputCars = Arrays.asList("a", "b");
        CarRacing carRacing = new CarRacing(inputCars, ((low, high) -> 0)); // 랜덤값 -> 항상 0
        int turn = 3;

        carRacing.race(turn);

        assertThat(outputStream.toString()).doesNotContain("-");
    }

}
