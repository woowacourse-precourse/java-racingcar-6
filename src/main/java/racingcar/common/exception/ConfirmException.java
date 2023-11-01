package racingcar.common.exception;

import java.util.List;

public class ConfirmException {
    public static void confirmCarName(List<String> carNames) {
        CarNameHavingEmptyException.havingEmpty(carNames);
        CarNameLengthException.nameLengthWrong(carNames);
        EmptyInputException.isEmptyInput(carNames);
        CarNameDuplicationException.isDuplication(carNames);
    }

    public static void confirmNumber(String number) {
        AttemptNotNumberException.notNumber(number);
    }
}
