package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private String[] inputNames;
    private static final Pattern nameValidatePattern = Pattern.compile("([\\S]{1,})");

    public void setInputNames() {
        String input = userInput();
        String[] names = input.split(",");
        validateNames(names);
        this.inputNames = names;
    }

    private static void validateNames(String[] names) {
        for (String name : names) {
            validateSpace(name);
            validateLength(name);
        }
    }

    private static void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5글자로 작성해주세요.");
        }
    }

    private static void validateSpace(String input) {
        if (!isNotSpace(input)) {
            throw new IllegalArgumentException("공백을 제거해주세요.");
        }
    }

    private static boolean isNotSpace(String input) {
        return nameValidatePattern.matcher(input).matches();
    }

    public String[] getInputNames() {
        return inputNames;
    }

    private static String userInput() {
        return Console.readLine();
    }

    //test method
    public void setInputNames(String input) {;
        String[] names = input.split(",");
        validateNames(names);
        this.inputNames = names;
    }
}
