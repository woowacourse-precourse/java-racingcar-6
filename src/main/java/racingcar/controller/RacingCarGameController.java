package racingcar.controller;

import racingcar.model.RacingCarGameModel;
import racingcar.model.RacingCarPlayerModel;
import racingcar.view.RacingCarGameView;
import racingcar.view.RacingCarPlayerView;

public class RacingCarGameController{
    private InputController inputController;
    private RacingCarFormatController racingCarFormatController;
    private RacingCarGameModel racingCarGameModel;

    private RacingCarGameView racingCarGameView;

    private RacingCarPlayerView racingCarPlayerView;

    public void init(){
        this.inputController = new InputController();
        this.racingCarFormatController = new RacingCarFormatController();
        this.racingCarGameModel = new RacingCarGameModel();
        this.racingCarGameView = new RacingCarGameView();
        this.racingCarPlayerView = new RacingCarPlayerView();
        this.startGame();
        this.endGame();
    }

    private void startGame() {
        this.initRacingCarGame();
        while(this.racingCarGameModel.getTryCount() > 0){
            this.movePlayers();
            this.racingCarPlayerView.printPlayersPosition(this.racingCarGameModel.getPlayers());
            this.racingCarGameModel.setTryCount(this.racingCarGameModel.getTryCount() - 1);
        }
        this.racingCarGameModel.setWinners();
    }

    private void endGame() {
        this.racingCarGameView.printWinners(this.racingCarGameModel.getWinners());
    }

    private void movePlayers(){
        this.racingCarGameModel.movePlayers();
    }

    private void initRacingCarGame(){
        this.racingCarGameView.printInputRacingCarPlayers();
        String players = this.inputController.inputRacingCarPlayers();
        this.racingCarGameModel.setPlayers(this.racingCarFormatController.formatStringToListRacingCarPlayer(players));
        this.racingCarGameView.printInputTryCount();
        this.racingCarGameModel.setTryCount(this.inputController.getTryCount());
    }
}
