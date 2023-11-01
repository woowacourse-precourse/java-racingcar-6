package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
