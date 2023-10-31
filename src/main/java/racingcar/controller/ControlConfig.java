package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.LimitScoreMoveRule;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.CarService;
import racingcar.view.inputview.SettingInputView;
import racingcar.view.outputview.PlayOutputView;
import racingcar.view.outputview.ResultOutputView;
import racingcar.view.outputview.SettingOutputView;

final class ControlConfig {
    private ControlConfig() {
    }

    static Controller createSettingController() {
        return new SettingController(new SettingInputView(), new SettingOutputView());
    }

    static Controller createPlayController(Object param) {
        if (param instanceof Cars cars) {
            return new PlayController(new PlayOutputView(),
                    new CarService(cars, new LimitScoreMoveRule(new RandomNumberGenerator())));
        }
        return null;
    }

    static Controller createResultController(Object param) {
        if (param instanceof Cars cars) {
            return new ResultController(new ResultOutputView(),
                    new CarService(cars, new LimitScoreMoveRule(new RandomNumberGenerator())));
        }
        return null;
    }
}
