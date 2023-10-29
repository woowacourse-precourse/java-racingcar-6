package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShowMessageTest {
    private final ByteArrayOutputStream outputStreamForTest = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStreamForTest));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void machineNameInputInstructionMessage() {
        Machines machines = new Machines();

        machines.showMessage();

        assertThat(outputStreamForTest.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    public void raceLapNumberInstructionMessage() {
        RaceLap raceLap = new RaceLap();

        raceLap.showMessage();

        assertThat(outputStreamForTest.toString().trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }
}