package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.CarGameModel;
import racingcar.model.CarPlayerModel;
import racingcar.view.input.CarGameInputView;
import racingcar.view.output.CarGameOutputView;
import racingcar.view.output.CarPlayerOutPutView;

public class CarGameController {
    private InputController inputController;
    private CarFormatController carFormatController;
    private CarGameModel carGameModel;
    private CarGameInputView carGameInputView;
    private CarGameOutputView carGameOutputView;
    private CarPlayerOutPutView carPlayerOutPutView;

    public void init() {
        this.inputController = new InputController();
        this.carFormatController = new CarFormatController();
        this.carGameInputView = new CarGameInputView();
        this.carGameOutputView = new CarGameOutputView();
        this.carPlayerOutPutView = new CarPlayerOutPutView();
        this.initCarGame();
        this.startGame();
        this.endGame();
    }

    private void startGame() {
        IntStream.range(0, this.carGameModel.getTryCount())
                .forEach(i -> {
                    this.movePlayers();
                    this.carPlayerOutPutView.printPlayersPosition(this.carGameModel.getPlayers());
                });
    }

    private void endGame() {
        this.carGameOutputView.printWinners(this.carGameModel.getWinners());
    }

    private void movePlayers() {
        this.carGameModel.movePlayers();
    }

    private void initCarGame() {
        this.carGameInputView.printInputCarPlayers();
        String players = this.inputController.readCarPlayers();
        List<CarPlayerModel> listPlayers = this.carFormatController.formatStringToListCarPlayer(players);
        this.carGameInputView.printInputTryCount();
        int tryCount = this.inputController.readTryCount();
        this.carGameModel = new CarGameModel(listPlayers, tryCount);
    }
}
