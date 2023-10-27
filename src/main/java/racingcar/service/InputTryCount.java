package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class InputTryCount {
    public static int setInputTryCount() {
        int tryCount = 0;
        String input = Console.readLine();
        tryCount = Integer.parseInt(input);
        return tryCount;
    }
}
