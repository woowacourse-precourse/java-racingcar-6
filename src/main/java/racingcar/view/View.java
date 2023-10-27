package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class View {

    private View() {}

    public static String getInput() {
        return readLine();
    }

    public static void printMessage(PromptMessage message){
        System.out.println(message.getMessage());
    }
}
