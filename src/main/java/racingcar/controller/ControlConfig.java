package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.LimitScoreMoveRule;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.CarService;
import racingcar.view.inputview.InputValidator;
import racingcar.view.inputview.SettingInputView;
import racingcar.view.outputview.PlayOutputView;
import racingcar.view.outputview.ResultOutputView;
import racingcar.view.outputview.SettingOutputView;

public class ControlConfig {
    private ControlConfig() {
    }

    public static Controller createSettingController() {
        return new SettingController(new SettingInputView(new InputValidator()), new SettingOutputView());
    }

    public static Controller createPlayController(Object param) {
        if (param instanceof Cars cars) {
            return new PlayController(new PlayOutputView(),
                    new CarService(cars, new LimitScoreMoveRule(new RandomNumberGenerator())));
        }
        return null;
    }

    public static Controller createResultController(Object param) {
        if (param instanceof Cars cars) {
            return new ResultController(new ResultOutputView(),
                    new CarService(cars, new LimitScoreMoveRule(new RandomNumberGenerator())));
        }
        return null;
    }
}
