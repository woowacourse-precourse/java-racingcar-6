package view;

import camp.nextstep.edu.missionutils.Console;
import validator.TryCountInputValidator;

public class TryCountInputView {
    TryCountInputValidator tryCountInputValidator = new TryCountInputValidator();

    public int receiveTryNumber() {
        String tryNumberInput = Console.readLine();
        int tryNumber = tryCountInputValidator.vaildInputNumber(tryNumberInput);
        return tryNumber;
    }
}
