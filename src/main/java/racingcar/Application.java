package racingcar;

import camp.nextstep.edu.missionutils.Console;
import javax.xml.catalog.Catalog;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.Constants;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView.inputString(Constants.INPUT_CAR_NAME_MESSAGE);
        InputView.inputString(Constants.INPUT_FORWARD_MOVE_TRY_COUNT_MESSAGE);
    }
}
