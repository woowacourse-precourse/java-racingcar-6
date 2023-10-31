package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    public List<String> carName() {
        String userInput = Console.readLine();
        List<String> carNameList = Arrays.asList(userInput.split(","));

        for (String s : carNameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
        return carNameList;
    }

    public int Round() {
        int UserInput;
        try {
            UserInput = Integer.parseInt(Console.readLine());
        } catch (java.lang.Exception WrongType) {
            throw new IllegalArgumentException("입력된 값의 형식이 숫자가 아닙니다.");
        }
        return UserInput;
    }
}
