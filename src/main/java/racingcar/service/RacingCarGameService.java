package racingcar.service;

import static racingcar.input.RacingCarInputReader.getRacingCarsFromConsole;
import static racingcar.printer.RacingCarPrinter.printCurrentDistanceStatus;
import static racingcar.printer.RacingCarPrinter.printMessageBeforePlay;
import static racingcar.printer.RacingCarPrinter.printWinnerOfPlay;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.VisibleForTesting;
import racingcar.input.RacingCarInputReader;

public class RacingCarGameService {
    private static final int RANDOM_GENERATE_START_NUM = 0;
    private static final int RANDOM_GENERATE_END_NUM = 9;

    public static void startGame() {
        List<RacingCar> racingCars = getRacingCarsFromConsole();
        int numberToPlay = RacingCarInputReader.getPlayNumberFromConsole();
        advanceRacingCarsUntilPlayNumber(racingCars, numberToPlay);
        printWinnerOfPlay(calculateWinner(racingCars));
    }

    private static void advanceRacingCarsUntilPlayNumber(List<RacingCar> racingCars, int numberToPlay) {
        printMessageBeforePlay();
        while(numberToPlay-- > 0) {
            advanceEachRacingCars(racingCars);
            printCurrentDistanceStatus(racingCars);
        }
    }

    private static void advanceEachRacingCars(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar ->
            racingCar.advanceByNumber(
                    Randoms.pickNumberInRange(
                            RANDOM_GENERATE_START_NUM, RANDOM_GENERATE_END_NUM)));
    }

    @VisibleForTesting
    protected static List<RacingCar> calculateWinner(List<RacingCar> racingCars) {
        int maxDistance = calculateMaxDistance(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.getAdvanceDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    @VisibleForTesting
    protected static int calculateMaxDistance(List<RacingCar> racingCars) {
        if (racingCars.isEmpty())
            return 0;

        return racingCars.stream()
                .map(RacingCar::getAdvanceDistance)
                .sorted(Comparator.reverseOrder())
                .toList()
                .get(0);
    }
}
