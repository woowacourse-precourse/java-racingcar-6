package racingcar.service.impl;

import racingcar.service.ValidateService;

public class ValidateServiceImpl implements ValidateService {
    @Override
    public void validateInputLastCharEqualCommas(String input) {
        char lastChar = input.charAt(input.length() - 1);
        if (lastChar == ',') {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateNamesSizeLessThanFive(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException();
        }
    }
}
