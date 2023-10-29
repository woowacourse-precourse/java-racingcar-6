package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static racingcar.service.InputService.*;
import static racingcar.service.PrintService.*;

public class GameService {
    static List<RacingCar> racingCars;
    static long maxLocation;

    public static void run() {
        printRacingCarNameInputForm();
        racingCars = createRacingCars();

        printTimesInputForm();
        long times = readTimes();

        printGameOutcomeMessage();
        playGameForTimes(times);

        findFinalWinner();
    }

    private static List<RacingCar> createRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = convertToStringArray(readInput());

        for (String carName : carNames)
            racingCars.add(RacingCar.createRacingCar(carName));

        return racingCars;
    }

    private static Long readTimes() {
        return convertToLong(readInput());
    }

    private static void playGameForTimes(Long times) {
        for (int i = 0; i < times; i++) {
            for (RacingCar racingCar : racingCars) {
                int num = Randoms.pickNumberInRange(0, 9);

                if (num >= 4)
                    racingCar.putForward(num);

                maxLocation = max(maxLocation, racingCar.getLocation());
            }

            printOneGameOutcome(racingCars);
        }
    }

    private static void findFinalWinner() {
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars)
            if (racingCar.getLocation().equals(maxLocation))
                winners.add(racingCar);

        printFinalWinner(winners);
    }
}
