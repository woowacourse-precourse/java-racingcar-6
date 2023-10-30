package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.inputview.InputValidator;
import racingcar.view.inputview.SettingInputView;
import racingcar.view.outputview.PlayOutputView;
import racingcar.view.outputview.ResultOutputView;
import racingcar.view.outputview.SettingOutputView;

public class ControlConfig {
    public Controller createSettingController() {
        return new SettingController(new SettingInputView(new InputValidator()), new SettingOutputView());

    }

    public Controller createRacingController(Object param) {
        if (param instanceof CarService service) {
            return new RacingController(new RacingOutputView(), service);
        }
        return null;
    }

    public Controller createResultController(Object param) {
        if (param instanceof CarService service) {
            return new ResultController(new ResultOutputView(), service);
        }
        return null;
    }
}
