package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    String input;

    public void print(String message) {
        System.out.println(message);
    }

    public void input() {
        this.input = readLine();
    }

    public String getInput() {
        return input;
    }
}
