package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleManager implements Input, Output{

    @Override
    public String readCarNames() {
        printGameMessage(GameMessage.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    @Override
    public String readGameCount() {
        printGameMessage(GameMessage.INPUT_GAME_COUNT);
        return Console.readLine();
    }

    @Override
    public void printGameMessage(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }
}
