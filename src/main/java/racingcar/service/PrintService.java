package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static racingcar.domain.StringConstant.*;

public class PrintService {
    public static void printRacingCarNameInputForm() {
        System.out.println(RACING_CAR_NAME_INPUT_FORM_MESSAGE);
    }

    public static void printTimesInputForm() {
        System.out.println(TIMES_INPUT_FORM_MESSAGE);
    }

    public static void printGameOutcomeMessage() {
        System.out.println();
        System.out.println(GAME_OUTCOME_MESSAGE);
    }

    public static void printOneGameOutcome(List<RacingCar> racingCars) {
        racingCars.forEach( racingCar -> {
            System.out.printf("%s : ", racingCar.getName());
            System.out.printf("%s", printLocation(racingCar.getLocation()));
            System.out.println();
        });

        System.out.println();
    }
        private static String printLocation(Long distance) {
            return LongStream.range(0, distance)
                    .mapToObj(i -> LOCATION_INDICATOR)
                    .collect(Collectors.joining());
        }

    public static void printWinners(List<RacingCar> winners) {
        String[] winnerNames = winners.stream()
                .map(RacingCar::getName)
                .toArray(String[]::new);

        System.out.printf("%s", WINNER_MESSAGE);
        System.out.printf("%s", String.join(CARS_JOIN_DELIMITER, winnerNames));
        System.out.println();
    }
}
