package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;


public class Racing {
    private RacingCars racingCars;
    private int round;
    private RacingPrinter racingPrinter;

    public Racing(RacingCars cars, int round) {
        this.racingCars = cars;
        this.round = round;
        this.racingPrinter = new RacingPrinter();
    }

    public void process() {
        while (round-- > 0) {
            race();
        }
    }

}