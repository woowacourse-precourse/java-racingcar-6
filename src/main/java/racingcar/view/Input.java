package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private static Input input = new Input();

    private Input() {
    }

    public static Input getInput() {
        return input;
    }

    public String inputFromUser() {
        return readLine();
    }

}
