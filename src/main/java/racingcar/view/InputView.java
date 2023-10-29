package racingcar.view;

import static racingcar.util.messageContent.OutputMessageContent.CAR_NICKNAME_REGISTER;
import static racingcar.util.messageContent.OutputMessageContent.GAME_TIME;

public class InputView {

    public static void displaySetUpNickname() {
        System.out.println(CAR_NICKNAME_REGISTER.getContent());
    }

    public static void displaySetUpPlayTime() {
        System.out.println(GAME_TIME.getContent());
    }
}
