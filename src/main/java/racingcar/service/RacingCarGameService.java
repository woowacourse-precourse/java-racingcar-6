package racingcar.service;

import static racingcar.input.RacingCarInputReader.getRacingCarsFromConsole;
import static racingcar.printer.RacingCarPrinter.printMessageBeforePlay;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.input.RacingCarInputReader;

public class RacingCarGameService {
    private static final int RANDOM_GENERATE_START_NUM = 0;
    private static final int RANDOM_GENERATE_END_NUM = 9;

    public static void startGame() {
        List<RacingCar> racingCars = getRacingCarsFromConsole();
        int numberToPlay = RacingCarInputReader.getPlayNumberFromConsole();
        advanceRacingCarsUntilPlayNumber(racingCars, numberToPlay);
    }

    private static void advanceRacingCarsUntilPlayNumber(List<RacingCar> racingCars, int numberToPlay) {
        printMessageBeforePlay();
        while(numberToPlay-- > 0) {
            advanceEachRacingCars(racingCars);
            // TODO : implement below
//            printCurrentDistanceStatus(racingCars);
        }
    }

    private static void advanceEachRacingCars(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar ->
            racingCar.advanceByNumber(
                    Randoms.pickNumberInRange(
                            RANDOM_GENERATE_START_NUM, RANDOM_GENERATE_END_NUM)));
    }
}
