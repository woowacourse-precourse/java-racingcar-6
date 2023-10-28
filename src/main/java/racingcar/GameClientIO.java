package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameClientIO {
    private static final String DELIMITER = ",";

    public List<String> getNames() {
        String input = Console.readLine();
        return List.of(input.split(DELIMITER));
    }
}
