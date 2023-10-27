package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> getRacingCarName() {
        String racingCarName =  Console.readLine();
        return Arrays.asList(racingCarName.split(","));
    }
}
