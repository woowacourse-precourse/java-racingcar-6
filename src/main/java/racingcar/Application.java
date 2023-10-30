package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.converter.inputConverter.InputConverterImpl;
import racingcar.model.validator.carName.CarNameValidatorImpl;
import racingcar.model.validator.moveCount.MoveCountValidatorImpl;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputViewImpl;
import racingcar.view.RaceView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceView raceView = new RaceView(new InputViewImpl(), new OutputViewImpl());
        RaceController raceController = new RaceController(raceView);
        raceController.initGame(new CarNameValidatorImpl(), new InputConverterImpl(), new MoveCountValidatorImpl());
    }
}
