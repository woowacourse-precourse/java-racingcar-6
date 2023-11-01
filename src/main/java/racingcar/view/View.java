package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.view.constant.Messageable;

public class View {

    public static String getInput() {
        return readLine();
    }

    public static void printMessage(Messageable messageable) {
        System.out.println(messageable.getMessage());
    }
}
