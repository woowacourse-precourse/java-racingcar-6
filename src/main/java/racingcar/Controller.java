package racingcar;

import racingcar.game.Game;

public class Controller {

    Game game = new Game();

    public void run(){
        setGame();
        playGame();
        endGame();
    }

    public void setGame(){
        game.setGame();
    }

    public void playGame(){
        game.playGame();
    }

    public void endGame(){
        game.endGame();
    }

}
