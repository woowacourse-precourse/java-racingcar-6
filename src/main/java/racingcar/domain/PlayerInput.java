package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class PlayerInput {
    public Map<String, Integer> nameInput() {
        Map<String, Integer> racers = new HashMap<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Validate validate = new Validate();
        for (String name : input.split(",")) {
            validate.NameLengthLimit(name);
            racers.put(name, 0);
        }
        return racers;
    }

    public int playTimeInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
