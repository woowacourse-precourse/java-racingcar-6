package view;

import static model.Constants.START_INPUT_MESSAGE;
import static model.Constants.NUMBER_ATTEMPTS_MESSAGE;


public class InputPhrase {
    public void startInputMessage() {
        System.out.println(START_INPUT_MESSAGE);
    }
    public void inputNumberAttempts() {
        System.out.println(NUMBER_ATTEMPTS_MESSAGE);
    }
}
