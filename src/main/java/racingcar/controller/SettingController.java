package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.inputview.SettingInputView;
import racingcar.view.outputview.SettingOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static racingcar.view.Parameter.GAME_COUNT;
import static racingcar.view.Parameter.Input.CAR_NAMES;
import static racingcar.view.Parameter.Output.CARS;
import static racingcar.view.inputview.SettingInputView.DELIMITER;

final class SettingController implements Controller {
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
        parameter.put(CAR_NAMES, null);
        model.put(CARS, null);
        settingOutputView.display(model);
        settingInputView.read(parameter);

        model.put(CARS, getCars(parameter));
    }

    private Cars getCars(Map<String, String> parameter) {
        String[] names = parameter.get(CAR_NAMES).trim().split(String.valueOf(DELIMITER));

        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    private void viewGameCount(Map<String, String> parameter, Map<String, Object> model) {
        parameter.put(GAME_COUNT, null);
        model.put(GAME_COUNT, null);
        settingOutputView.display(model);
        settingInputView.read(parameter);

        int gameCount = Integer.parseInt(parameter.get(GAME_COUNT));
        model.put(GAME_COUNT, gameCount);
    }
}
