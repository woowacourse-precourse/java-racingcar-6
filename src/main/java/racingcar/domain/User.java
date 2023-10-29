package racingcar.domain;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public List<String> cars = new ArrayList<>();
    public int gameNumber;

    public User() {
        InputCarName();
        InputGameNumber();
    }
    public void InputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Arrays.asList(Console.readLine().split(","));
    }
    public void InputGameNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        gameNumber = Integer.parseInt(Console.readLine());
    }
}

