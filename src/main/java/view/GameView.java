package view;

import message.GameMessage;

public class GameView {

    private static GameView defaultGameView;

    private GameView() {
    }

    public static GameView getInstance() {
        if(defaultGameView == null) {
            defaultGameView = new GameView();
        }
        return defaultGameView;
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

    public void close() {
        defaultGameView = null;
    }

}
