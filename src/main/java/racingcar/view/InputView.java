package racingcar.view;

import static racingcar.utility.Constants.CAR_NAME_INPUT_PROMPT_MESSAGE;
import static racingcar.utility.Constants.RACING_COUNT_INPUT_PROMPT_MESSAGE;

public class InputView {
    private static final InputView inputView = new InputView();

    private InputView(){}

    public static InputView getInstance(){
        return inputView;
    }

    public void printCarNameInputPromptMessage(){
        System.out.println(CAR_NAME_INPUT_PROMPT_MESSAGE);
    }

    public void printRacingCountInputPromptMessage(){
        System.out.println(RACING_COUNT_INPUT_PROMPT_MESSAGE);
    }
}
