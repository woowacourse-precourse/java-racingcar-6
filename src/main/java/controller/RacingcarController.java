package controller;

import model.RacingGame;
import view.CarNamesGuideOutputView;
import view.CarNamesInputVIew;
import view.TryCountInputView;
import view.TryCountOutputView;

public class RacingcarController {
    public void gameStart() {
        CarNamesGuideOutputView carNamesGuideOutputView = new CarNamesGuideOutputView();
        CarNamesInputVIew carNamesInputVIew = new CarNamesInputVIew();
        TryCountOutputView tryCountOutputView = new TryCountOutputView();
        TryCountInputView tryCountInputView = new TryCountInputView();

        carNamesGuideOutputView.printGameStart();
        String[] carNames = carNamesInputVIew.receiveCarNames();

        tryCountOutputView.printGameStart();
        int tryCount = tryCountInputView.receiveTryNumber();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.play();
    }
}
