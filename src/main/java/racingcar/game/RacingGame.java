package racingcar.game;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class RacingGame {
    private static final String LAP_RESULT_DELIMITER = "\n";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final int MINIMUM_END_LAP = 1;

    private final List<RacingCar> racingCars;
    private final int endLap;

    public RacingGame(List<RacingCar> racingCars, int endLap) {
        validateRacingCars(racingCars);
        validateEndLap(endLap);

        this.racingCars = racingCars;
        this.endLap = endLap;
    }

    public void run() {
        System.out.println("실행 결과");

        for (int lap = 1; lap <= endLap; lap++) {
            racingCars.forEach(RacingCar::start);

            printLapResult();
        }

        printRaceResult();
    }

    private void validateRacingCars(List<RacingCar> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다.");
        }

        long uniqueNameCount = racingCars.stream()
                .map(RacingCar::getName)
                .distinct()
                .count();

        if (racingCars.size() != uniqueNameCount) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateEndLap(int endLap) {
        if (endLap < MINIMUM_END_LAP) {
            throw new IllegalArgumentException("시도 횟수는 %d보다 작을 수 없습니다.".formatted(MINIMUM_END_LAP));
        }
    }

    private void printLapResult() {
        String lapResult = racingCars.stream()
                .map(RacingCar::raceState)
                .collect(Collectors.joining(LAP_RESULT_DELIMITER));

        System.out.printf("%s\n%n", lapResult);
    }

    private void printRaceResult() {
        int maxLap = racingCars.stream()
                .map(RacingCar::getLap)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("최종 우승자를 조회할 수 없습니다."));

        String winnerNames = racingCars.stream()
                .filter(racingCar -> racingCar.isSameLap(maxLap))
                .map(RacingCar::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));

        System.out.printf("최종 우승자 : %s%n", winnerNames);
    }
}
