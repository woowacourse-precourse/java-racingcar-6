package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class ConsoleInputView implements InputView {
    public static final String DELIMITER_DESCRIPTION = "쉼표";
    public static final String DELIMITER = ",";

    @Override
    public List<String> enterCarNames() {
        return List.of(
                readLine().split(getDelimiter())
        );
    }

    @Override
    public String getDelimiterDescription() {
        return DELIMITER_DESCRIPTION;
    }

    @Override
    public String getDelimiter() {
        return DELIMITER;
    }

    @Override
    public int enterTryCount() {
        return Integer.parseInt(readLine());
    }
}
