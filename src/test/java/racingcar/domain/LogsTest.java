package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LogsTest {
    private OutputStream captor;
    private Car car;

    @BeforeEach
    void setUp() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void inputCarNames() {
        String log = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator();
        Logs.inputCarNames();
        assertThat(captor.toString()).isEqualTo(log);
    }

    @Test
    void inputGameTurns() {
        String log = "시도할 회수는 몇회인가요?" + System.lineSeparator();
        Logs.inputGameTurns();
        assertThat(captor.toString()).isEqualTo(log);
    }

    @Test
    void newLine() {
        String log = System.lineSeparator();
        Logs.newLine();
        assertThat(captor.toString()).isEqualTo(log);
    }

    @Test
    void getGameResult() {
        String log = "실행결과" + System.lineSeparator();
        Logs.getGameResult();
        assertThat(captor.toString()).isEqualTo(log);
    }

    @Test
    void car() {
        String log = "myCar : -------";

        car = mock(Car.class);
        when(car.toString()).thenReturn(log);

        Logs.car(car);
        assertThat(captor.toString()).isEqualTo(log + System.lineSeparator());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi, woni, jun", "pobi, jun", "woni, jun"})
    void string(String log) {
        Logs.string(log);
        assertThat(captor.toString()).isEqualTo(log + System.lineSeparator());
    }
}