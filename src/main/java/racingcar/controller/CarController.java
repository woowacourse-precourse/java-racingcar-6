package racingcar.controller;

import racingcar.model.Car;
import racingcar.constant.GameSettingCharacter;
import racingcar.validator.NameDuplicateValidator;
import racingcar.validator.NamesCountValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {
    private final List<Car> racingCars = new ArrayList<>();
    private final InputView inputView = new InputView();

    private List<String> inputToCarNameList(String playerInput) {
        List<String> carNames = Arrays.asList(playerInput.split(GameSettingCharacter.SEPARATOR_CHARACTER.get()));

        NamesCountValidator namesCountValidator = new NamesCountValidator();
        namesCountValidator.validate(carNames);

        NameDuplicateValidator nameDuplicateValidator = new NameDuplicateValidator();
        nameDuplicateValidator.validate(carNames);

        return carNames;
    }

    public List<Car> getRacingCars(String playerInput) {
        for (String carName : inputToCarNameList(playerInput)) {
            racingCars.add(new Car(carName.trim()));
        }
        return racingCars;
    }
}
