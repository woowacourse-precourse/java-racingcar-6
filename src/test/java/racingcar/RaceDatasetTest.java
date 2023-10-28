package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceDatasetTest {
    String mockInput = "alpha,bravo,charlie";
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
    public void createDefaultPaceMap() {
        Machines machines = new Machines();
        PaceComputer paceComputer = new PaceComputer();

        machines.getInput();

        LinkedHashMap<String, Integer> test = paceComputer.createDefaultPaceMap(machines);

        assertThat(test.keySet()).containsExactly("alpha", "bravo", "charlie");
        assertThat(test.values()).containsExactly(0, 0, 0);
    }
}
