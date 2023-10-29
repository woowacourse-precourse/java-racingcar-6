package racingcar.model;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine().charAt(0) - '0';
    }
}
