package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Attempt {
    public int attemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptNum;
        String inputNum = Console.readLine();

        attemptNum = checkInt(inputNum);

        return attemptNum;
    }

    public int checkInt(String inputNum) {
        try {
            int num = Integer.parseInt(inputNum);
            return num;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
