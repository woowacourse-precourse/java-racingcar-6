package racingcar.view.validator;

import java.util.Arrays;
import racingcar.view.constants.Numbers;
import racingcar.view.constants.Strings;

public class InputValidator {

    private static void handleNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Strings.NULL_OR_EMPTY_ERROR.getMessage());
        }
    }

    private static void handleInvalidLetter(String input, String validLetters) {
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            if (validLetters.indexOf(currentLetter) < 0) {
                throw new IllegalArgumentException(Strings.INVALID_LETTER_ERROR.getMessage());
            }
        }
    }

    private static void handleLastCharacterIsNotComma(String carName) {
        if (carName.endsWith(",")) {
            throw new IllegalArgumentException(Strings.LAST_CHARACTER_IS_COMMA_ERROR.getMessage());
        }
    }

    private static void handleLengthOfCarName(String[] carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > Numbers.MAX_NAME_LENGTH.getNumber()) {
                throw new IllegalArgumentException(Strings.LENGTH_OF_CAR_NAME_ERROR.getMessage());
            }
        }
    }

    private static void handleNumberOfCarNames(String[] carNames) {
        if (carNames.length < Numbers.MIN_GAME_PLAYER.getNumber()
                || carNames.length > Numbers.MAX_GAME_PLAYER.getNumber()) {
            throw new IllegalArgumentException(Strings.NUMBER_OF_CARS_ERROR.getMessage());
        }
    }

    private static void handleDuplicatedCarNames(String[] carNames) {
        Arrays.sort(carNames);
        for (int i = 1; i < carNames.length; i++) {
            if (carNames[i - 1].equals(carNames[i])) {
                throw new IllegalArgumentException(Strings.DUPLICATED_CAR_NAME_ERROR.getMessage());
            }
        }
    }

    private static void handlePlayTimeOutOfRange(String playtime) {
        if (playtime.length() > 4) {
            throw new IllegalArgumentException(Strings.PLAYTIME_OUT_OF_RANGE_ERROR.getMessage());
        }
        int intTypePlayTime = Integer.parseInt(playtime);
        if (intTypePlayTime <= 0 || intTypePlayTime > Numbers.MAX_GAME_PLAY.getNumber()) {
            throw new IllegalArgumentException(Strings.PLAYTIME_OUT_OF_RANGE_ERROR.getMessage());
        }
    }

    public static void validateCarName(String carName) {
        handleNullOrEmpty(carName);
        handleInvalidLetter(carName, Strings.VALID_CAR_NAME_LETTERS.getMessage());
        handleLastCharacterIsNotComma(carName);

        String[] carNames = carName.split(",");
        handleLengthOfCarName(carNames);
        handleNumberOfCarNames(carNames);
        handleDuplicatedCarNames(carNames);
    }

    public static void validatePlayTime(String playtime) {
        handleNullOrEmpty(playtime);
        handleInvalidLetter(playtime, Strings.VALID_PLAYTIME_LETTERS.getMessage());
        handlePlayTimeOutOfRange(playtime);
    }
}
