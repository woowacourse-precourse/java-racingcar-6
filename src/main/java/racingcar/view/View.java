package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.view.constant.Message;

public class View {
    
    public static String getInput() {
        return readLine();
    }

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
