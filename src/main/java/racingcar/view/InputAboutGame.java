package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputAboutGame {
    public static List<String> InputCarNames() {
        String CarNames = readLine();
        List CarNamesList = Arrays.asList(CarNames.split(","));
        return CarNamesList;
    }

    public static int InputAttempt() {
        String AttemptNumber = readLine();
        return Integer.parseInt(AttemptNumber);
    }
}
