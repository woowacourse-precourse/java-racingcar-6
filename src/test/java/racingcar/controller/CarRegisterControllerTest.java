package racingcar.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class CarRegisterControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private RacingCars racingCars;
    private CarRegisterController carRegisterController;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
        carRegisterController = new CarRegisterController(racingCars);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void registerCars() {
        String input = "pobi,woni,jun\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        carRegisterController.registerCars();

        List<String> registeredCarNames = racingCars.getCarNames();
        assertThat(registeredCarNames).containsExactly("pobi", "woni", "jun");

        System.setIn(System.in);
    }
}
