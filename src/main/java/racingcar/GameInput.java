package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class GameInput {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public int receiveMovingNum(){
        String movingNum = Console.readLine();
        validateNumber(movingNum);
        return Integer.parseInt(movingNum);
    }

    public List<String> receiveCarNames(){
        List<String> names = splitByComma(Console.readLine());
        validateName(names);
        return names;
    }

    public List<String> splitByComma(String contents){
        return Arrays.asList(contents.split(","));
    }

    public void validateNumber(String movingNum){
        if (!movingNum.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("this num is not valid");
        }
    }

    public void validateName(List<String> names){
        for (String name : names) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("carname length must be < " + MAX_CAR_NAME_LENGTH);
            }
        }
    }

}
