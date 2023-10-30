package racingcar.domain;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {
    static int count;
    static List<String> carName;

    public InputValue() {
        String inputCount;
        String inputName;

        ResultPrinter.startMessage();
        inputName = readLine();
        ResultPrinter.getTryMessage();
        inputCount = readLine();
        count = Integer.parseInt(inputCount);
    }
}