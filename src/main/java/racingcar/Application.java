package racingcar;

import view.CarNamesGuideOutputView;
import view.CarNamesInputVIew;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNamesGuideOutputView carNamesGuideOutputView = new CarNamesGuideOutputView();
        CarNamesInputVIew carNamesInputVIew = new CarNamesInputVIew();
        carNamesGuideOutputView.printGameStart();
        carNamesInputVIew.receiveCarNames();
    }
}
