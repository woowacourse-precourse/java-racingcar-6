package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class GameInput {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String MOVING_NUMBER_PATTERN = "^[1-9][0-9]*$";


    public String readInput() {
        return Console.readLine();
    }

    public List<String> splitInput(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public int convertToMovingNumber(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public List<String> convertToCarNameList(String input) {
        List<String> names = splitInput(input, ",");
        validateName(names);
        return names;
    }

    public void validateNumber(String movingNum) {
        if (!movingNum.matches(MOVING_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("Input number is not valid");
        }
    }

    public void validateName(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("carname length must be < " + MAX_CAR_NAME_LENGTH);
            }
        }
    }

}
