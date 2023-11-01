package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class CarRegisterControllerTest {
    private RacingCars racingCars;
    private CarRegisterController carRegisterController;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
        carRegisterController = new CarRegisterController(racingCars);
    }

    @Test
    void registerCars() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        carRegisterController.registerCars(names);

        List<String> registeredCarNames = racingCars.getCarNames();
        assertThat(registeredCarNames).containsExactlyElementsOf(names);
    }
}
