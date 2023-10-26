package view;

import message.GameMessage;

public class GameView {

    public GameView() {

    }

    public void printResult() {
        System.out.println(GameMessage.newLine.getMessage() + GameMessage.result.getMessage());
    }

}
