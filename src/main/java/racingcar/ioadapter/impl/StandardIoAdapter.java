package racingcar.ioadapter.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ioadapter.IoAdapter;

public class StandardIoAdapter implements IoAdapter {
    @Override
    public String inputStream() {
        return Console.readLine();
    }

    @Override
    public void outputResult(String result) {
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
