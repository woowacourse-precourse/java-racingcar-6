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
        for (RacingCar racingCar : racingCars) {
            System.out.printf("%s : ", racingCar.getName());
            System.out.printf("%s", printLocation(racingCar.getLocation()));
            System.out.println();
        }
    }
        private static String printLocation(Long distance) {
            return LongStream.range(0, distance)
                    .mapToObj(i -> LOCATION_INDICATOR)
                    .collect(Collectors.joining());
        }

    public static void printFinalWinner(List<RacingCar> winners) {
        String[] winnerNames = new String[winners.size()];

        for (int i = 0; i < winnerNames.length; i++)
            winnerNames[i] = winners.get(i).getName();

        System.out.printf("%s", FINAL_WINNER_MESSAGE);
        System.out.printf("%s", String.join(CAR_JOIN_DELIMITER, winnerNames));
        System.out.println();
    }
}
