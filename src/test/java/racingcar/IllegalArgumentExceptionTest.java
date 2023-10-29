package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IllegalArgumentExceptionTest {

    @BeforeEach
    public void setUpStream() {
        String mockInput = "abracadabra\nmagic";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
    }

    @Test
    public void machineNameWithinFiveLetters() {
        Machines machines = new Machines();

        assertThatThrownBy(machines::getInput).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void lapAsANumber() {
        RaceLap raceLap = new RaceLap();

        assertThatThrownBy(raceLap::getInput).isInstanceOf(IllegalArgumentException.class);
    }
}