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
            names.add(name);
        }

        return names;
    }
}
