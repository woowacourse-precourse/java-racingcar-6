package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetInputTest {

    @BeforeEach
    public void setUpStream() {
        String mockInput = "alpha,bravo,charm\n5";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
    }

    @Test
    public void getMachineNamesThenRaceLapNumber() {
        Machines machines = new Machines();
        RaceLap raceLap = new RaceLap();

        String machineNames = machines.getInput();
        String lapNumber = raceLap.getInput();

        assertThat(machineNames).isEqualTo("alpha,bravo,charm");
        assertThat(lapNumber).isEqualTo("5");
    }
}