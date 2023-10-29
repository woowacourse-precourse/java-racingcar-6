package racingcar.domain;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public List<String> cars = new ArrayList<>();

    public User() {
        InputCarName();
    }
    public void InputCarName() {
        cars = Arrays.asList(Console.readLine().split(","));
        System.out.println(cars);
    }
}

