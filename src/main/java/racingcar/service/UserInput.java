package racingcar.service;

import static racingcar.constant.constantMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.constant.constantMessage.TRY_COUNT_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String[] inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        String[] names = input.split(",");

        return names;
    }

    public String tryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
