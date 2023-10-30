package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] nameArray = input.split(",");

        List<String> names = new ArrayList<>();
        for (String name : nameArray) {
            isValidName(name);
            names.add(name);
        }

        return names;
    }

    public void isValidName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getTryCount() {
        String input = Console.readLine();
        isValidNum(input);
        int count = Integer.parseInt(input);
        return count;
    }

    public void isValidNum(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < 0) {
                throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자는 입력할 수 없습니다.");
        }
    }
}
