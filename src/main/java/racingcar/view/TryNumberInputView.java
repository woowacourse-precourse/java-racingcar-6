package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class TryNumberInputView {
    public String inputTry() {
        printTry();
        return Console.readLine();
    }

    public void printTry() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
