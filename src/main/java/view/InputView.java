package view;

import camp.nextstep.edu.missionutils.Console;

import message.GameMessage;

public class InputView {

    public InputView() {

    }

    public String inputCarNames() {
        System.out.println(GameMessage.start.getMessage());
        return Console.readLine();
    }

    public String inputRaceCount() {
        System.out.println(GameMessage.count.getMessage());
        return Console.readLine();
    }

}
