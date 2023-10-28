package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetInputTest {
    String mockInput = "alpha,bravo,charlie\n5";
    private final InputStream inOriginal = System.in;

    @BeforeEach
    public void setUpStream() {
        String simulatedInput  = mockInput;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(inOriginal);
    }

    @Test
    public void getMachineNamesThenLap() {
        Machines machines = new Machines();
        Lap lap = new Lap();

        String machineNames = machines.getInput();
        String lapNumber = lap.getInput();

        assertThat(machineNames).isEqualTo("alpha,bravo,charlie");
        assertThat(lapNumber).isEqualTo("5");
    }
}