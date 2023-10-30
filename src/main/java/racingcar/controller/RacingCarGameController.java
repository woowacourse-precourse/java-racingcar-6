package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
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
        this.racingCarGameView = new RacingCarGameView();
        this.racingCarPlayerView = new RacingCarPlayerView();
        this.initRacingCarGame();
        this.startGame();
        this.endGame();
    }

    private void startGame() {
        IntStream.range(0, this.racingCarGameModel.getTryCount())
            .forEach(i -> {
                this.movePlayers();
                this.racingCarPlayerView.printPlayersPosition(this.racingCarGameModel.getPlayers());
            });
    }

    private void endGame() {
        this.racingCarGameView.printWinners(this.racingCarGameModel.getWinners());
    }

    private void movePlayers(){
        this.racingCarGameModel.movePlayers();
    }

    private void initRacingCarGame(){
        this.racingCarGameView.printInputRacingCarPlayers();
        String players = this.inputController.readRacingCarPlayers();
        List<RacingCarPlayerModel> listPlayers= this.racingCarFormatController.formatStringToListRacingCarPlayer(players);
        this.racingCarGameView.printInputTryCount();
        int tryCount = this.inputController.readTryCount();
        this.racingCarGameModel = new RacingCarGameModel(listPlayers, tryCount);
    }
}
