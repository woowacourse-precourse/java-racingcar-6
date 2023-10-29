package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private String[] inputNames;
    private int numberOfAttempts;

    private static final Pattern nameValidatePattern = Pattern.compile("([\\S]{1,})");
    private static final Pattern numberValidatePattern = Pattern.compile("([\\d]{1,})");

    public void setInputNames() {
        String input = userInput();
        String[] names = input.split(",");
        validateNames(names);
        this.inputNames = names;
    }

    public void setNumberOfAttempts() {
        String input = userInput();
        validateNumber(input);
        validateNumberZero(input);
        this.numberOfAttempts = Integer.parseInt(input);
    }

    private static void validateNumberZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException("1이상의 숫자만 입력해주세요.");
        }
    }

    private static void validateNumber(String input) {
        if (!validatePattern(input, numberValidatePattern)) {
            throw new IllegalArgumentException("1이상의 숫자만 입력해주세요.");
        }
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
        if (!validatePattern(input, nameValidatePattern)) {
            throw new IllegalArgumentException("공백을 제거해주세요.");
        }
    }

    private static boolean validatePattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }

    public String[] getInputNames() {
        return inputNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    private static String userInput() {
        return Console.readLine();
    }

    // 아래는 test를 위한 method
    public void setInputNames(String input) {;
        String[] names = input.split(",");
        validateNames(names);
        this.inputNames = names;
    }

    public void setNumberOfAttempts(String numberOfAttempts) {
        validateNumber(numberOfAttempts);
        validateNumberZero(numberOfAttempts);
        this.numberOfAttempts = Integer.parseInt(numberOfAttempts);
    }
}
