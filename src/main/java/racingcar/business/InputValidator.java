package racingcar.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    //자동차 이름 예외 체크
    public void validateCarsName(List<String> cars) {
        if (validateCarsNameLength(cars)) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        else if (validateCarsNameDuplicate(cars)) throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
    }

    //자동차 이름, 시도할 횟수 예외 체크
    public void validateInputValue(String inputValue) {
        if (validateInputForSpaces(inputValue)) throw new IllegalArgumentException("입력값에 띄어쓰기가 포함되어 있습니다.");
        else if (validateInputEmpty(inputValue)) throw new IllegalArgumentException("입력값이 비어있습니다.");
    }

    //시도할 횟수 예외 체크
    public void validateAttempts(String attempts) {
        if (!validateNumericOnly(attempts)) throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
    }

    private boolean validateCarsNameLength(List<String> cars) {
        boolean result = false;
        for (String car : cars) if (car.length() > 5) result = true;
        return result;
    }

    //자동차 이름 중복 체크
    private boolean validateCarsNameDuplicate(List<String> cars) {
        Set<String> carsSet = new HashSet<>(cars);
        return cars.size() != carsSet.size();
    }

    //입력값에 띄어쓰기 검사
    private boolean validateInputForSpaces(String inputValue) {
        return inputValue.contains(" ");
    }

    private boolean validateInputEmpty(String inputValue) {
        return inputValue.isEmpty();
    }

    private boolean validateNumericOnly(String attempts) {
        return attempts.matches("\\d+");
    }
}
