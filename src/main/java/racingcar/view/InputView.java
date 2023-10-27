package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> readRacingCarName() {
        String racingCarName =  Console.readLine();
        return Arrays.asList(racingCarName.split(","));
    }
}
