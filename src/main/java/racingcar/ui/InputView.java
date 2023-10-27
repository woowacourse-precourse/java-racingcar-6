package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String SPLITTER = ",";

    private List<String> splitNames(String input) {
        //TODO String[], List<String>중 어느것이 더 적절할까?
        return Arrays.asList(input.split(SPLITTER));
    }
    private String getInput() {
        return Console.readLine();
    }

    private void close() {
        Console.close();
    }
}
