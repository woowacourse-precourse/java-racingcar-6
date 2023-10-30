package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.inputview.SettingInputView;
import racingcar.view.outputview.SettingOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static racingcar.view.inputview.SettingInputView.DELIMITER;

public class SettingController implements Controller {
    private final SettingInputView settingInputView;
    private final SettingOutputView settingOutputView;

    SettingController(SettingInputView settingInputView, SettingOutputView settingOutputView) {
        this.settingInputView = settingInputView;
        this.settingOutputView = settingOutputView;
    }

    @Override
    public void run(Map<String, String> parameter, Map<String, Object> model) {
        viewCarNames(parameter, model);
        viewGameCount(parameter, model);
    }

    private void viewCarNames(Map<String, String> parameter, Map<String, Object> model) {
        parameter.put("carNames", null);
        model.put("cars", null);
        settingOutputView.display(model);
        settingInputView.read(parameter);

        model.put("cars", getCars(parameter));
    }

    private Cars getCars(Map<String, String> parameter) {
        String[] names = parameter.get("carNames").trim().split(String.valueOf(DELIMITER));

        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    private void viewGameCount(Map<String, String> parameter, Map<String, Object> model) {
        parameter.put("gameCount", null);
        model.put("gameCount", null);
        settingOutputView.display(model);
        settingInputView.read(parameter);

        int gameCount = Integer.parseInt(parameter.get("gameCount"));
        model.put("gameCount", gameCount);
    }
}
