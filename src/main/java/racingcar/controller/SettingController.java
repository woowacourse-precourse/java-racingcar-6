package racingcar.controller;

import racingcar.view.inputview.SettingInputView;
import racingcar.view.outputview.SettingOutputView;

import java.util.Map;

public class SettingController implements Controller {
    private final SettingInputView settingInputView;
    private final SettingOutputView settingOutputView;

    public SettingController(SettingInputView settingInputView, SettingOutputView settingOutputView) {
        this.settingInputView = settingInputView;
        this.settingOutputView = settingOutputView;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {
        getAndView(parameter, model, "carNames");
        getAndView(parameter, model, "gameCount");

        createCars(parameter.get("cars"));
    }

    private void createCars(String obj) {
    }

    private void getAndView(Map<String, String> parameter, Map<String, Object> model, String name) {
        model.put(name, null);
        settingOutputView.display(model);
        settingInputView.read(parameter);
    }
}
