package racingcar.utils;

import static racingcar.utils.Constants.MAX_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_NAME_LENGTH;
import static racingcar.utils.Constants.MIN_NUMBER_OF_CARS;
import static racingcar.utils.Constants.MIN_NUMBER_OF_ROUNDS;

import java.util.List;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNumberOfCars(int sizeOfCarList) {
        if (sizeOfCarList < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("1대 이상의 차량을 입력하세요.");
        }
    }

    public static void validateIsNamesDistinct(List<String> carNames) {
        boolean isNotDistinctNames = (carNames.stream().distinct().count() != carNames.size());

        if (isNotDistinctNames) {
            throw new IllegalArgumentException("중복되지 않는 이름들을 입력하세요.");
        }
    }

    public static void validateNameLength(int nameLength) {
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("1자 이상, 5자이하의 이름을 입력하세요.");
        }
    }

    public static void validateIsInputNumber(String userInput) {
        boolean isNotNumber = !userInput.chars().allMatch(Character::isDigit);

        if (isNotNumber) {
            throw new IllegalArgumentException("음수가 아닌 숫자를 입력하세요.(숫자 사이 공백 불가)");
        }
    }

    public static void validateIsNaturalNumber(int integer) {
        if (integer < MIN_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException("시도 횟수는 1이상인 자연수를 입력해야합니다.");
        }
    }

}
