package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    public List<String> readNames() {
        String input = Console.readLine();
        return List.of(input.split(SPLIT_REGEX));
    }

    public int readTryCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
