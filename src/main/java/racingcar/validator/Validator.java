package racingcar.validator;

import racingcar.message.ExceptionMessage;

import java.util.List;

public class Validator {

    public static void validateCarNames(List<String> carNames) {
        if (!isFiveCharactersOrLess(carNames)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MORE_THAN_FIVE);
        }

        if (isEmptyOrBlank(carNames)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EMPTY_AND_BLANK);
        }

        if (hasDuplicatesCarName(carNames)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DUPLICATE_NAME);
        }
    }

    public static void validateCarTrying(String answer) {
        if (!isAnswerDigit(answer) || !isAnswerPositiveNumber(answer)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER);
        }
    }

    public static boolean hasDuplicatesCarName(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

    private static boolean isEmptyOrBlank(List<String> carNames) {
        return carNames.stream().anyMatch(String::isEmpty);
    }

    private static boolean isFiveCharactersOrLess(List<String> carNames) {
        return carNames.stream().allMatch(carName -> carName.length() <= 5);
    }

    private static boolean isAnswerDigit(String answer) {
        return answer.chars().allMatch(Character::isDigit);
    }

    private static boolean isAnswerPositiveNumber(String answer) {
        return Integer.parseInt(answer) > 0;
    }
}
