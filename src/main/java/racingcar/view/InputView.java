package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private String[] inputNames;
    private final Pattern nameValidatePattern = Pattern.compile("([\\S]{1,})");

    public void setInputNames() {
        String input = userInput();
        validateSpace(input);
        String[] names = input.split(",");
        this.inputNames = names;
    }

    private void validateSpace(String input) {
        if (!nameValidatePattern.matcher(input).matches()) {
            throw new IllegalArgumentException("공백을 제거해주세요.");
        }
    }

    public String[] getInputNames() {
        return inputNames;
    }

    private static String userInput() {
        return Console.readLine();
    }

    //test method
    public void setInputNames(String input) {;
        validateSpace(input);
        String[] names = input.split(",");
        this.inputNames = names;
    }
}
