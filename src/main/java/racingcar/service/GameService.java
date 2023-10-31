package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.domain.NumberConstant.*;
import static racingcar.service.InputService.*;
import static racingcar.service.OutputService.*;

public class GameService {
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


    public static void playGameForTimes(Long times, List<RacingCar> racingCars) {
        for (int i = 0; i < times; i++) {
            addLocationForRandomNumber(racingCars);

            printOneGameOutcome(racingCars);
        }
    }

    private static void addLocationForRandomNumber(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int num = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            if (num >= MIN_INCREMENT_NUMBER)
                racingCar.putForward();
        }
    }


    public static List<RacingCar> findWinners(List<RacingCar> racingCars) {
        long maxLocation = findMaxLocation(racingCars);

        return racingCars.stream()
                .collect(Collectors.groupingBy(RacingCar::getLocation))
                .get(maxLocation);
    }

    private static Long findMaxLocation(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToLong(RacingCar::getLocation)
                .max()
                .orElse(Long.MIN_VALUE);
    }
}
