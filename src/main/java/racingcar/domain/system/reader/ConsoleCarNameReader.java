package racingcar.domain.system.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.exceptions.argument.EmptyCarNameException;

public class ConsoleCarNameReader implements CarNameReader {

    private static final String DELIMITER = ",";

    @Override
    public List<String> read() {
        String source = Console.readLine();
        List<String> names = new ArrayList<>();
        String[] nameSources = source.split(DELIMITER);
        for (String nameSource : nameSources) {
            if (nameSource.isBlank()) {
                throw new EmptyCarNameException();
            }
            names.add(getFitName(nameSource));
        }
        return names;
    }

    private String getFitName(String nameSource) {
        return nameSource.trim();
    }
}
