package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final String separator = ",";

    public List<String> carNames() {
        String carNamesWithSeparator = Console.readLine();
        String[] tokens = StringManipulator.splitSeparator(carNamesWithSeparator, separator);
        List<String> carNamesWithoutSeparator = StringManipulator.toList(tokens);
        return carNamesWithoutSeparator;
    }

    public int tryNumber(){
        String trialNum = Console.readLine();
        return Integer.parseInt(trialNum);
    }
}
