package racingcar.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {
    public static List<String> parseCarName(String inputAnswer){
        String[] splitAnswer = inputAnswer.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(splitAnswer));
        for (String carName : carNames){
            if (!isStringLengthLessThanOrEqualToFive(carName)) {
                throw new IllegalArgumentException("차 이름은 5글자 이하로 해주세요.");
            }
        }

        return carNames;
    }

    private static Boolean isStringLengthLessThanOrEqualToFive(String carName){
        return carName.length() <= 5;
    }

    public static int parseIntTurnAnswer(String inputAnswer){
        String pattern = "^[0-9]+$";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(inputAnswer);

        if (matcher.matches()) {
            return Integer.parseInt(inputAnswer);
        } else {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

}
