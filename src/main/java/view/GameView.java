package view;

import message.GameMessage;

public class GameView {

    public GameView() {

    }

    public void printResult() {
        System.out.println(GameMessage.newLine.getMessage() + GameMessage.result.getMessage());
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printWinners(String winners) {
        System.out.println(GameMessage.winner.getMessage() + GameMessage.equal.getMessage() + winners);
    }

}
