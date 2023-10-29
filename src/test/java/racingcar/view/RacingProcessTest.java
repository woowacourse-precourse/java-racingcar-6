package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.RacingProcess.showOneRound;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RacingProcessTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
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
    void 한_라운드_실행_결과_출력_테스트() {
        List<Car> cars = setCars();
        cars.get(0).updateDistance(STOP);
        for (int idx = 1; idx < cars.size(); idx++) {
            cars.get(idx).updateDistance(MOVING_FORWARD);
        }
        showOneRound(cars);
        assertThat(outputStreamCaptor.toString()).contains("abcd : ", "hi : -", "j : -");
    }

    List<Car> setCars() {
        List<Car> cars = new ArrayList<>();
        List<String> names = Arrays.asList("abcd", "hi", "j");
        names.stream().forEach(name -> cars.add(new Car(name)));
        return cars;
    }
}
