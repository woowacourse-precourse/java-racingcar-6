package racingcar;

import java.util.Arrays;
import java.util.List;

public class GameUtil {
    public List<String> splitByCommas(String target) {
        return Arrays.asList(target.split(","));
    }
}
