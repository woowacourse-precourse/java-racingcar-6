package racingcar.domain.racing;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;

class RacingPrinterTest extends NsTest {

    @Test
    void updateRacingResult() {
        // Assert
        assertAll(
                () -> {
                   run();
                   Assertions.assertTrue(output().contains("pobi : --"));
                   Assertions.assertTrue(output().contains("woni : -"));
                }
        );
    }

    @Override
    protected void runMain() {
        // Arrange & Act
        RacingPrinter printer = new RacingPrinter();

        RacingCars cars = new RacingCars(
                List.of(
                    new RacingCar("pobi", 2),
                    new RacingCar("woni", 1)
                )
        );

        printer.updateRacingResult(cars);
        System.out.println(printer.getRacingResult());
    }
}