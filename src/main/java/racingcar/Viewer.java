package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Viewer {
    private final String CAR_NAME_DELIMITER = ",";

    public List<String> inputCarNames() {
        List<String> carNameList = Arrays
                .stream(readLine().split(CAR_NAME_DELIMITER))
                .toList();
        return carNameList;
    }
}
