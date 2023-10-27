package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

import racingcar.view.message.Message;

public class View {

    private View() {}

    public static String getInput() {
        return readLine();
    }

    public static void printMessage(Message message){
        System.out.println(message.getMessage());
    }
}
