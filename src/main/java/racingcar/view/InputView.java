package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;


public class InputView {

    public static List<String> inputNames() {
        String names = readLine();
        return Arrays.asList(names.split(","));
    }
}
