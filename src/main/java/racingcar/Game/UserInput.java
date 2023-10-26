package racingcar.Game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    Exception exception = new Exception();

    public List<String> CarName() throws IllegalArgumentException {
        String UserInput = Console.readLine();
        List<String> carNameList = Arrays.asList(UserInput.split(","));

        for (String s : carNameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }

        return carNameList;
    }

    public int Round() throws IllegalArgumentException {
        int UserInput;

        try {
            UserInput = Integer.parseInt(Console.readLine());
        } catch (java.lang.Exception WrongType) {
            throw new IllegalArgumentException("입력된 값의 형식이 숫자가 아닙니다.");
        }

        return UserInput;
    }
}
