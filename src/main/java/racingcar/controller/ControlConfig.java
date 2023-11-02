package racingcar.controller;

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

    static Controller createPlayController() {
        return new PlayController(new PlayOutputView());
    }

    static Controller createResultController() {
        return new ResultController(new ResultOutputView());
    }
}