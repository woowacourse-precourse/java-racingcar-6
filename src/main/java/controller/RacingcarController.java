package controller;

import view.CarNamesGuideOutputView;
import view.CarNamesInputVIew;
import view.TryCountOutputView;

public class RacingcarController {
    public void gameStart() {
        CarNamesGuideOutputView carNamesGuideOutputView = new CarNamesGuideOutputView();
        CarNamesInputVIew carNamesInputVIew = new CarNamesInputVIew();
        TryCountOutputView tryCountOutputView = new TryCountOutputView();

        carNamesGuideOutputView.printGameStart();
        carNamesInputVIew.receiveCarNames();
        tryCountOutputView.printGameStart();
    }
}
