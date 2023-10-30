package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarInputView {
    public String carNameInput() {
        System.out.println(Messages.GUIDE_INPUT_NAME_MESSAGE);
        String names = Console.readLine();
        try {
            Validator.validateNames(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return names;
    }
}
