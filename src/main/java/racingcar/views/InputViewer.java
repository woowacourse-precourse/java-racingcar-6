package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

public class InputViewer {
    public static String requestCarNameInput(){
        OutputViewer.printRequestCarNameMessage();
        return Console.readLine();

    }
}
