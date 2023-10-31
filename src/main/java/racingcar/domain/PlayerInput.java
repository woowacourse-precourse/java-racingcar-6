package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class PlayerInput {
    public static Map<String, Integer> NameInput() {
        Map<String, Integer> racers = new HashMap<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        for (String name : input.split(",")) {
            racers.put(name, 0);
        }
        return racers;
    }
}
