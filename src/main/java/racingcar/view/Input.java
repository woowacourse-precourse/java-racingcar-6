package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public Input() {
    }

    public void printGameStartMessage(String message) {
        System.out.println(message);
    }

    public void printPlayTimeQuestion(String message) {
        System.out.println(message);
    }

    public String writeUserInput() {
        return Console.readLine();
    }

    public void close(){
        Console.close();
    }

}
