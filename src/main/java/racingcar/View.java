package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class View {
    private final String DELIMITER = ",";

    public String[] inputCarNames() {
        String read = Console.readLine();
        String[] names = read.split(DELIMITER);
        return names;
    }
}
