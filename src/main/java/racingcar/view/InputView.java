package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> readRacingCarName() {
        String racingCarName = Console.readLine();
        return Arrays.stream(racingCarName.split(","))
                .map(String::trim)
                .toList();
    }
}
