package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @Test
    public void makeRandomNumberTest() {
        Computer computer = new Computer();
        int randomNumber = computer.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
