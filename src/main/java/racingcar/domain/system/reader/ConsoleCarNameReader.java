package racingcar.domain.system.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleCarNameReader implements CarNameReader {

    private static final String DELIMITER = ",";

    @Override
    public List<String> read() {
        String source = Console.readLine();
        List<String> names = new ArrayList<>();
        String[] nameSources = source.split(DELIMITER);
        for (String nameSource : nameSources) {
            names.add(getFitName(nameSource));
        }
        return names;
    }

    private String getFitName(String nameSource) {
        return nameSource.trim();
    }
}
