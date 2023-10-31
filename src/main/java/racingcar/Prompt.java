package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.RacingConst.CAR_NAME_SPLITTER;
import static racingcar.RacingConst.INPUT_CAR_NAMES;
import static racingcar.RacingConst.INPUT_MAC_TURN;
import static racingcar.RacingConst.WINNERS;

import java.util.List;
import java.util.Map;

public class Prompt {

    public static String[] readCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        String input = readLine();
        String[] carNames = input.split(CAR_NAME_SPLITTER);
        for (String carName : carNames) {
            if (Validator.isNotCarName(carName)) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public static Integer readMaxTurn() {
        System.out.println(INPUT_MAC_TURN);
        String input = readLine();
        if (Validator.isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public static void printCarPositions(Map<String, Integer> cars) {
        cars.forEach((car, position) -> {
            System.out.println(car + " : " + "-".repeat(position));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNERS);
        for (int car = 0; car < winners.size(); car++) {
            System.out.print(winners.get(car));
            if (car != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
