package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleManager implements Input, Output{

    @Override
    public String readCarNames() {
        return Console.readLine();
    }

    @Override
    public void printGameMessage(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

}
