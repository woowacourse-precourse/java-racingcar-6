package racingcar.view.validator;

import java.util.Arrays;
import racingcar.view.constants.Messages;
import racingcar.view.constants.Numbers;

public class InputValidator {

    private static void handleIsNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Messages.NULL_OR_EMPTY_ERROR.getMessage());
        }
    }

    private static void handleOnlyContainsValidLetter(String input, String validLetters) {
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            if (validLetters.indexOf(currentLetter) < 0) {
                throw new IllegalArgumentException(Messages.INVALID_LETTER_ERROR.getMessage());
            }
        }
    }

    private static void handleLengthOfCarName(String[] carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > Numbers.MAX_NAME_LENGTH.getNumber()) {
                throw new IllegalArgumentException(Messages.LENGTH_OF_CAR_NAME_ERROR.getMessage());
            }
        }
    }

    private static void handleNumberOfCarNames(String[] carNames) {
        if (carNames.length == 0 || carNames.length > Numbers.MAX_GAME_PLAYER.getNumber()) {
            throw new IllegalArgumentException(Messages.NUMBER_OF_CARS_ERROR.getMessage());
        }
    }

    private static void handleDuplicatedCarNames(String[] carNames) {
        Arrays.sort(carNames);
        for (int i = 1; i < carNames.length; i++) {
            if (carNames[i - 1].equals(carNames[i])) {
                throw new IllegalArgumentException(Messages.Duplicated_Car_Name_Error.getMessage());
            }
        }
    }


    private static void handlePlayTimeInRange(String playtime) {
        int intTypePlayTime = Integer.parseInt(playtime);
        if (intTypePlayTime <= 0 || intTypePlayTime > Numbers.MAX_GAME_PLAY.getNumber()) {
            throw new IllegalArgumentException();
        }
    }


    public static void validateCarName(String carName) {
        handleIsNullOrEmpty(carName);
        handleOnlyContainsValidLetter(carName, Messages.VALID_CAR_NAME_LETTERS.getMessage());
        
        String[] carNames = carName.split(",");
        handleLengthOfCarName(carNames);
        handleNumberOfCarNames(carNames);
        handleDuplicatedCarNames(carNames);
    }


    public static void validatePlayTime(String playtime) {
        handleIsNullOrEmpty(playtime);
        handleOnlyContainsValidLetter(playtime, Messages.VALID_PLAYTIME_LETTERS.getMessage());
        handlePlayTimeInRange(playtime);
    }


}
