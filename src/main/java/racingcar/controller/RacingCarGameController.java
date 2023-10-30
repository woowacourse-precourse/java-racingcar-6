package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.RacingCarGameModel;
import racingcar.model.RacingCarPlayerModel;
import racingcar.view.input.RacingCarGameInputView;
import racingcar.view.output.RacingCarGameOutputView;
import racingcar.view.output.RacingCarPlayerOutPutView;

public class RacingCarGameController{
    private InputController inputController;
    private RacingCarFormatController racingCarFormatController;
    private RacingCarGameModel racingCarGameModel;
    private RacingCarGameInputView racingCarGameInputView;
    private RacingCarGameOutputView racingCarGameOutputView;
    private RacingCarPlayerOutPutView racingCarPlayerOutPutView;

    public void init(){
        this.inputController = new InputController();
        this.racingCarFormatController = new RacingCarFormatController();
        this.racingCarGameInputView = new RacingCarGameInputView();
        this.racingCarGameOutputView = new RacingCarGameOutputView();
        this.racingCarPlayerOutPutView = new RacingCarPlayerOutPutView();
        this.initRacingCarGame();
        this.startGame();
        this.endGame();
    }

    private void startGame() {
        IntStream.range(0, this.racingCarGameModel.getTryCount())
            .forEach(i -> {
                this.movePlayers();
                this.racingCarPlayerOutPutView.printPlayersPosition(this.racingCarGameModel.getPlayers());
            });
    }

    private void endGame() {
        this.racingCarGameOutputView.printWinners(this.racingCarGameModel.getWinners());
    }

    private void movePlayers(){
        this.racingCarGameModel.movePlayers();
    }

    private void initRacingCarGame(){
        this.racingCarGameInputView.printInputRacingCarPlayers();
        String players = this.inputController.readRacingCarPlayers();
        List<RacingCarPlayerModel> listPlayers= this.racingCarFormatController.formatStringToListRacingCarPlayer(players);
        this.racingCarGameInputView.printInputTryCount();
        int tryCount = this.inputController.readTryCount();
        this.racingCarGameModel = new RacingCarGameModel(listPlayers, tryCount);
    }
}
