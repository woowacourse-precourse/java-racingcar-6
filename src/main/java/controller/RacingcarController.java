package controller;

import view.CarNamesGuideOutputView;
import view.CarNamesInputVIew;

public class RacingcarController {
    public void gameStart() {
        CarNamesGuideOutputView carNamesGuideOutputView = new CarNamesGuideOutputView();
        CarNamesInputVIew carNamesInputVIew = new CarNamesInputVIew();
        carNamesGuideOutputView.printGameStart();
        carNamesInputVIew.receiveCarNames();
    }
}
