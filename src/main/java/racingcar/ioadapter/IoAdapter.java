package racingcar.ioadapter;

import java.util.List;

public interface IoAdapter {

    String inputStream();

    void outputResult(List<String> scores);

    void printMessage(String message);

    void printNewLine();
}
