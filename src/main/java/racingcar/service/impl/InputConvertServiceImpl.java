package racingcar.service.impl;

import java.util.Arrays;
import java.util.List;
import racingcar.service.InputConvertService;
import racingcar.service.ValidateService;

public class InputConvertServiceImpl implements InputConvertService {

    private final ValidateService validateService;

    public InputConvertServiceImpl(ValidateService validateService) {
        this.validateService = validateService;
    }

    @Override
    public void inputConvertCarPark(String input) {
        validateService.validateInputLastCharEqualCommas(input);
        List<String> carNames = Arrays.asList(input.split(","));
        for (String carName : carNames) {
            validateService.validateNamesSizeLessThanFive(carName);
        }

    }
}
