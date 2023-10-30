package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] inputCarName() {
        return Console.readLine().split(",");
    }

    public String inputTryCount() {
        return Console.readLine();
    }
}
