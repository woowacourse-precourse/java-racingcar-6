package racingcar.printer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCar;

class RacingCarPrinterTest {

    @Test
    public void getCurrentStatusWithBar_test() {
        // given
        RacingCar racingCar = new RacingCar("test");
        advanceRacingCar(racingCar);
        advanceRacingCar(racingCar);

        // when
        String result = RacingCarPrinter.getCurrentStatusWithBar(racingCar);

        // then
        assertEquals(result, "test : --");
    }

    @Test
    public void convertDistanceToBar_test() {
        // given
        int distance = 4;

        // when
        String result = RacingCarPrinter.convertDistanceToBar(distance);

        // then
        assertEquals(result, "----");
    }

    @Test
    public void convertListToNamesOfOneLine_test() {
        // given
        RacingCar racingCar1 = new RacingCar("test1");
        RacingCar racingCar2 = new RacingCar("test2");
        RacingCar racingCar3 = new RacingCar("test3");
        List<RacingCar> racingCars = Lists.newArrayList(racingCar1, racingCar2, racingCar3);

        // when
        String result = RacingCarPrinter.convertListToNamesOfOneLine(racingCars);

        // then
        assertEquals(result, "test1, test2, test3");
    }

    private static void advanceRacingCar(RacingCar racingCar) {
        racingCar.advanceByNumber(4);
    }
}