package racingcar.service;

import static racingcar.input.RacingCarInputReader.getRacingCarsFromConsole;

import java.util.List;
import racingcar.input.RacingCarInputReader;

public class RacingCarGameService {
    private static final int RANDOM_GENERATE_START_NUM = 0;
    private static final int RANDOM_GENERATE_END_NUM = 9;

    public static void startGame() {
        List<RacingCar> racingCars = getRacingCarsFromConsole();
        int numberToPlay = RacingCarInputReader.getPlayNumberFromConsole();
        advanceRacingCars(racingCars, numberToPlay);
    }

    private static void advanceRacingCars(List<RacingCar> racingCars, int numberToPlay) {

    }
}
