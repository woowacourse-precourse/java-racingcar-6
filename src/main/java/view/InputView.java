package view;

import camp.nextstep.edu.missionutils.Console;

import message.GameMessage;

public class InputView {

    private static InputView defaultInputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if(defaultInputView == null) {
            defaultInputView = new InputView();
        }
        return defaultInputView;
    }

    public String inputCarNames() {
        System.out.println(GameMessage.start.getMessage());
        return Console.readLine();
    }

    public String inputRaceCount() {
        System.out.println(GameMessage.count.getMessage());
        return Console.readLine();
    }

    public void close() {
        Console.close();
        defaultInputView = null;
    }

}
