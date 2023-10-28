package racingcar.controller;

import racingcar.domain.RacingcarGame;
import racingcar.domain.dto.InitDTO;
import racingcar.view.InitScreen;

public class GameController {
    private final RacingcarGame game;
    public GameController(){
        this.game = new RacingcarGame();
    }
    public void execute(){
        start();
        play();
        end();
    }
    private void start(){
        InitDTO initDTO = InitScreen.init();
        game.start(initDTO);
    }

    private void play(){

    }

    private void end(){

    }
}
