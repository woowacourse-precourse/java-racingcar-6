package racingcar;

import racingcar.control.ControlGame;


public class Application {
    public static void main(String[] args) {
        ControlGame game = new ControlGame();
        game.StartGame();
        game.PlayGame();
        game.EndGame();
    }
}
