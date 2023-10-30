package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputOutputHandler {
    public String inputText(){
        return Console.readLine();
    }

    public void printText(String text) {
        System.out.print(text);
    }

    public void printlnText(String text) {
        System.out.println(text);
    }

}
