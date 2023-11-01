package racingcar.input.count;

import camp.nextstep.edu.missionutils.Console;

public class CountReader {
    public static int read() {
        String inputCount = Console.readLine();
        CountValidator.isValid(inputCount);
        return Integer.parseInt(inputCount);
    }
}
