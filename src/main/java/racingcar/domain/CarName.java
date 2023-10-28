package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CarName {
    public final List<String> inputCarName() {
        String CarNames = Console.readLine();
        return Arrays.asList(CarNames.split(","));
    }
}