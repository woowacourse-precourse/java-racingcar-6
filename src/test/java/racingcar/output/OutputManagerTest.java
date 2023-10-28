package racingcar.output;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputManagerTest {
    private OutputManager outputManager;
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void init() {
        outputManager = new OutputManager();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void after() {
        System.setOut(out);
    }

    @Test
    @DisplayName("게임 시작 문구 출력")
    void print() {
        outputManager.printStartGame();
        Assertions.assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}