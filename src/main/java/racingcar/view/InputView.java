package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> racingCars() {
        String racingCarNames = Console.readLine();
        return Arrays.stream(racingCarNames.split(",")).toList();
    }

    public static int gameTurn() {
        return Integer.parseInt(Console.readLine());
    }
}
