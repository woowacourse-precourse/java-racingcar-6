package racingcar.ioadapter.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ioadapter.IoAdapter;

public class StandardIoAdapter implements IoAdapter {
    @Override
    public String inputStream() {
        String inputStream = Console.readLine();
        return inputStream;
    }

    @Override
    public String outputResult(String result) {
        return null;
    }
}
