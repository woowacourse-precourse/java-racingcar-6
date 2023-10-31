package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.domain.NumberConstant.*;
import static racingcar.service.InputService.*;
import static racingcar.service.OutputService.*;

public class GameService {
    public static void runGame() {
        // 자동차 이름 입력
        printRacingCarNameInputForm();
        List<RacingCar> racingCars = createRacingCars();

        // 횟수 입력
        printTimesInputForm();
        long times = readTimes();

        // 게임 진행 및 회차 별 결과 출력
        printGameOutcomeMessage();
        playGameForTimes(times, racingCars);

        // 최종 우승자 출력
        List<RacingCar> winners = findWinners(racingCars);
        printWinners(winners);
    }

    static List<RacingCar> createRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = convertToStringArray(readInput());

        for (String carName : carNames)
            racingCars.add(RacingCar.createRacingCar(carName));

        return racingCars;
    }

    static Long readTimes() {
        return convertToLong(readInput());
    }

    static void playGameForTimes(Long times, List<RacingCar> racingCars) {
        for (int i = 0; i < times; i++) {
            GameService.addLocationForRandomNumber(racingCars);

            printOneGameOutcome(racingCars);
        }
    }

    static List<RacingCar> findWinners(List<RacingCar> racingCars) {
        long maxLocation = GameService.findMaxLocation(racingCars);

        return racingCars.stream()
                .collect(Collectors.groupingBy(RacingCar::getLocation))
                .get(maxLocation);
    }

    private static void addLocationForRandomNumber(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int num = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            if (num >= MIN_INCREMENT_NUMBER)
                racingCar.putForward();
        }
    }


    private static Long findMaxLocation(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToLong(RacingCar::getLocation)
                .max()
                .orElse(Long.MIN_VALUE);
    }
}
