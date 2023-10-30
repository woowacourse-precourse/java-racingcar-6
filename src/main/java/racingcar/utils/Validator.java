package racingcar.utils;

import java.util.List;

public class Validator {
    private void validateInputCarOneToFive(List<String> input) {
        if (input.size() < 2 || input.size() > 5) {
            throw new IllegalArgumentException("자동차는 콤마로 구분하여 최소 두대 이상 최대 다섯대 이하로 입력해야 합니다.");
        }
    }

    private void validateInputCarNameIsEnglish(String input) {
        if (input == null || !input.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("이름은 영문만 가능합니다.");
        }
    }

    private void validateCarName(List<String> input) {
        for(String carName : input) {
            validateInputCarNameIsEnglish(carName);
        }
    }

    public void validateInputCar(List<String> input) {
        validateInputCarOneToFive(input);
        validateCarName(input);
    }
}
