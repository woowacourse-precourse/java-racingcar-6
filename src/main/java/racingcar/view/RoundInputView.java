package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.errormessage.InputError;

public class RoundInputView {

    private static final String INPUT_MESSAGE = "시도할 회수를 몇회인가요?\n";

    public int generateInputList() {
        System.out.print(INPUT_MESSAGE);
        String number = Console.readLine();
        validateInputIsNumber(number);
        validateEmptyString(number);
        return Integer.parseInt(number);
    }

    private void validateInputIsNumber(String numbers) {
        for (int i = 0; i < numbers.length(); ++i) {
            if (numbers.charAt(i) < 48 || numbers.charAt(i) > 57) {
                throw new IllegalArgumentException(InputError.INPUT_NOT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private void validateEmptyString(String number){
        if(number.equals("")) throw new IllegalArgumentException(InputError.INPUT_EMPTY_ERROR_MESSAGE);
    }
}
