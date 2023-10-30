package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
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
        Console.close();
        System.setIn(System.in);
    }

    @Test
    public void getCarNamesThenRaceLapNumber() {
        Cars cars = new Cars();
        RaceLap raceLap = new RaceLap();

        String carNames = cars.getInput();
        String lapNumber = raceLap.getInput();

        assertThat(carNames).isEqualTo("alpha,bravo,charm");
        assertThat(lapNumber).isEqualTo("5");
    }
}