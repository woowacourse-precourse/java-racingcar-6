package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class InputManager {
    static final String MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String MSG_INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

    public int getAttemptCountInput() {
        System.out.println(MSG_INPUT_ATTEMPT_COUNT);
        String answer = Console.readLine();

        return Integer.parseInt(answer);
    }

    public List<String> getCarNameInput() {
        System.out.println(MSG_INPUT_CAR_NAME);
        String answer = Console.readLine();

        return toListString(answer);
    }

    public List<String> toListString(String str) {
        String[] arry = str.split(",");

        List<String> list = new ArrayList<>();
        for (String sample : arry) {
            list.add(sample);
        }

        return list;
    }

}
