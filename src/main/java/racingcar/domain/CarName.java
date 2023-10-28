package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CarName {
    public final List<String> inputCarName() {
        String inputCarNames = Console.readLine();
        return Arrays.asList(inputCarNames.split(","));
    }
}