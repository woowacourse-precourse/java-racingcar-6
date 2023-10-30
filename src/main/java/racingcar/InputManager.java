package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputManager {
    public ArrayList<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] nameArray = input.split(",");

        ArrayList<String> names = new ArrayList<>();
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
       int count = Integer.parseInt(input);

       return count;
    }
}
