package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.InputMessage.*;

public class InputView {

    public String inputCars() {
        System.out.println(CARS.getMessage());
        return Console.readLine();
    }

    public String inputAttemptNumber() {
        System.out.println(ATTEMPT_NUMBER.getMessage());
        return Console.readLine();
    }
}
