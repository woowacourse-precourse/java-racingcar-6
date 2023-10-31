package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    private static final String CARNAME_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_NOTICE = "시도할 회수는 몇회인가요?";

    public List<String> carName() {
        System.out.println(CARNAME_NOTICE);
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
        System.out.println(ROUND_NOTICE);
        int UserInput;
        try {
            UserInput = Integer.parseInt(Console.readLine());
        } catch (java.lang.Exception WrongType) {
            throw new IllegalArgumentException("입력된 값의 형식이 숫자가 아닙니다.");
        }
        return UserInput;
    }
}
