package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShowMessageTest {
    private final ByteArrayOutputStream outForTest = new ByteArrayOutputStream();
    private final PrintStream outOriginal = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outForTest));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(outOriginal);
    }

    @Test
    public void machineNameInputInstructionMessage() {
        Machines machines = new Machines();

        machines.showMessage();

        assertThat(outForTest.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    public void lapInstructionMessage() {
        Lap lap = new Lap();

        lap.showMessage();

        assertThat(outForTest.toString().trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }
}