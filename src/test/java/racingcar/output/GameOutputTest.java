package racingcar.output;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class GameOutputTest {
    private GameOutput gameOutput;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        gameOutput = new GameOutput();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanStreams() {
        System.setOut(System.out);
    }

    @Test
    void 차수별_실행결과_출력_기능_확인() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.moveForward();
        gameOutput.currentStatus(List.of(car1, car2));

        assertThat(outContent.toString()).contains("pobi : -", "woni : ");
    }
}