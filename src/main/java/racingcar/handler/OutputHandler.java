package racingcar.handler;

import java.util.List;
import java.util.Map;

public interface OutputHandler {

    public void printInputCarNameMessage();

    public void printInputTryCountMessage();

    public void printGameResultMessage();

    public void printGameProgress(List<Map<String, String>> stageGameResults);

    public void printFinalWinners(String winners);
}
