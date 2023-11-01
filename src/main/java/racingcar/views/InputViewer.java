package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

public class InputViewer {
    private InputViewer() {
    }

    public static String requestCarNameInput() {
        OutputViewer.printRequestingCarName();
        return Console.readLine();
    }

    public static String requestNumberOfTry() {
        OutputViewer.printRequestingNumberOfTry();
        return Console.readLine();
    }
}
