package racingcar;

import javax.xml.catalog.Catalog;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView ss = new InputView();
        System.out.println(ss.inputCarName());
    }
}
