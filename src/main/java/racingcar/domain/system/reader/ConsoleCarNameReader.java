package racingcar.domain.system.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleCarNameReader implements CarNameReader {

    private static final String DELIMITER = ",";

    @Override
    public List<String> read() {
        String names = Console.readLine();
        return Arrays.asList(names.split(DELIMITER));
    }
}
