package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String[] inputNames;

    public void setInputNames() {
        String input = userInput();
        String[] names = input.split(",");
        this.inputNames = names;
    }

    public String[] getInputNames() {
        return inputNames;
    }

    private static String userInput() {
        return Console.readLine();
    }
}
