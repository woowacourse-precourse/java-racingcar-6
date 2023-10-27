package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String COMMA = ",";

    public List<String> getCarNames() {
        return Arrays.stream(Console.readLine().split(COMMA)).toList();
    }

    public String getRacingTrial() {
        return Console.readLine();
    }
}
