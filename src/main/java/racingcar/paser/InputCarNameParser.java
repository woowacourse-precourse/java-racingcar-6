package racingcar.paser;

import java.util.Arrays;
import java.util.List;

public class InputCarNameParser implements Parser<String, String> {

    private static final String DELIMITER = ",";

    @Override
    public List<String> parsing(String target) {
        String[] splitTarget = target.split(DELIMITER);
        return Arrays.asList(splitTarget);
    }
}
