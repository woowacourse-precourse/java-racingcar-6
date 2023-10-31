package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {
    public List<String> carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carName = List.of(input.split(","));

        return carName;
    }
}
