package racingcar.view;

import static racingcar.view.constant.ViewConstant.ATTEMPT_NUMBER_INPUT;
import static racingcar.view.constant.ViewConstant.CAR_NAME_INPUT;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utill.Validator;

public class InputView {
    public static String inputCarsNameView() {
        System.out.println(CAR_NAME_INPUT);
        String carsName = Console.readLine();
        Validator.validateNullInput(carsName);
        Validator.validateCarsName(carsName);
        return carsName;
    }

    public static int inputAttemptNumberView() {
        System.out.println(ATTEMPT_NUMBER_INPUT);
        String attemptNumber = Console.readLine();
        Validator.validateNullInput(attemptNumber);
        Validator.validateAttemptNumber(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }


}
