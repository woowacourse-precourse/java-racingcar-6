package racingcar.ioadapter.impl;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.ioadapter.IoAdapter;

public class StandardIoAdapter implements IoAdapter {
    @Override
    public String inputStream() {
        return Console.readLine();
    }

    @Override
    public void outputResult(List<String> scores) {
        scores.forEach(System.out::println);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
