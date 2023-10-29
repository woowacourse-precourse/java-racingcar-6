package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LogsTest {
    OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void inputCarNames() {
        String log = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator();
        Logs.inputCarNames();
        assertThat(out.toString()).isEqualTo(log);
    }

    @Test
    void inputGameTurns() {
    }

    @Test
    void newLine() {
    }

    @Test
    void getGameResult() {
    }

    @Test
    void car() {
    }

    @Test
    void string() {
    }
}