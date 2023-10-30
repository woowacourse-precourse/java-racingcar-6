package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    public UserInput() {
    }
    public List<String> carName() {
        String input = Console.readLine();;
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(names));
//        System.out.println(carNames);
        return carNames;
    }
    public int attemptCount() {
        int attemptCount;
        attemptCount = Integer.parseInt(Console.readLine());
//        System.out.println(attemptCount);
        return attemptCount;
    }
    public void processException() {
    }
}