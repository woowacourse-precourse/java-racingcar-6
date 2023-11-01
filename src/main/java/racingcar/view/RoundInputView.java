package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.errormessage.InputError;

public class RoundInputView {

    private static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";

    public int generateRoundNumber() {
        System.out.print(INPUT_MESSAGE);
        String number = Console.readLine();
        validateEmptyString(number);
        validateInputIsNumber(number);
        return Integer.parseInt(number);
    }

    private void validateInputIsNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) < 48 || number.charAt(i) > 57) {
                throw new IllegalArgumentException(InputError.INPUT_NOT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private void validateEmptyString(String number){
        if(number.equals("")) throw new IllegalArgumentException(InputError.INPUT_EMPTY_ERROR_MESSAGE);
    }
}
