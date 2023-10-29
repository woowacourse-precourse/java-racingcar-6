package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static racingcar.service.InputService.*;
import static racingcar.service.PrintService.*;

public class GameService {
    public static void run() {
        printRacingCarNameInputForm();
        List<RacingCar> racingCars = createRacingCars();

        printTimesInputForm();
        long times = readTimes();

        printGameOutcomeMessage();
        long maxLocation = playGameForTimes(times, racingCars);

        List<RacingCar> winners = findWinners(maxLocation, racingCars);
        printWinners(winners);
    }

    public static List<RacingCar> createRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = convertToStringArray(readInput());

        for (String carName : carNames)
            racingCars.add(RacingCar.createRacingCar(carName));

        return racingCars;
    }

    public static Long readTimes() {
        return convertToLong(readInput());
    }

    public static Long playGameForTimes(Long times, List<RacingCar> racingCars) {
        long maxLocation = 0;

        for (int i = 0; i < times; i++) {
            for (RacingCar racingCar : racingCars) {
                int num = Randoms.pickNumberInRange(0, 9);

                if (num >= 4)
                    racingCar.putForward();

                maxLocation = max(maxLocation, racingCar.getLocation());
            }

            printOneGameOutcome(racingCars);
        }

        return maxLocation;
    }

    public static List<RacingCar> findWinners(Long maxLocation, List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars)
            if (racingCar.getLocation().equals(maxLocation))
                winners.add(racingCar);

        return winners;
    }
}
