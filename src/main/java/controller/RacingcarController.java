package controller;

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
        carNamesInputVIew.receiveCarNames();
        tryCountOutputView.printGameStart();
        tryCountInputView.receiveTryNumber();
    }
}
