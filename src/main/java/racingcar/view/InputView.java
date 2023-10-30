package racingcar.view;

import static racingcar.constant.Constant.READ_CAR_NAME_MESSAGE;
import static racingcar.constant.Constant.READ_MOVE_COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidation;
import racingcar.validation.CountValidation;

public final class InputView {

    public static String readCarName() {
        System.out.println(READ_CAR_NAME_MESSAGE);
        String carName = Console.readLine();
        CarNameValidation.isEmptyInput(carName);
        return carName;
    }

    public static String readMoveCount() {
        System.out.println(READ_MOVE_COUNT_MESSAGE);
        String moveCount = Console.readLine();
        CountValidation.isEmptyInput(moveCount);
        return moveCount;
    }
}
