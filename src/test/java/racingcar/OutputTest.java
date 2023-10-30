package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class OutputTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("각 차수별 실행 결과 테스트")
    void output_실행결과 () {
        List<String> names = List.of("pobi", "java");
        int attempt = 3;
        List<Integer> mileages = List.of(1, 2);
        Car car = new Car(names, attempt, mileages);

        OutputView.displayRacingSituation(car);
        String result = "pobi : -" + System.lineSeparator() + "java : --";

        assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());
    }
}
