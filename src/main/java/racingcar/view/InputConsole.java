package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputConsole {

    public static List<String> readRacerNames() {
        String[] racerNames = Console.readLine().split(",");
        return Arrays.stream(racerNames)
                .toList();
    }

    public static int readRaceNumberOfTime() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
