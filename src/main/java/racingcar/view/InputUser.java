package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.Message.GameViewMessage;

public class InputUser {
    public String userInputCarNameString(){
        displayWriteCarNameMessage();
        return Console.readLine();
    }

    public String userInputRoundLength(){
        displayWriteRaceLengthMessage();
        return Console.readLine();
    }

    private void displayWriteCarNameMessage() {
        System.out.println(GameViewMessage.WRITE_CAR_NAME_MESSAGE.getMessage());
    }

    private void displayWriteRaceLengthMessage() {
        System.out.println(GameViewMessage.WRITE_RACE_LENGTH_MESSAGE.getMessage());
    }

}
