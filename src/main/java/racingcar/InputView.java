package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] readCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        return carNames;
    }

    public int readCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
