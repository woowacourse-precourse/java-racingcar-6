package racingcar.view.validator;

import racingcar.view.constants.Numbers;

public class InputValidator {
    public static void validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < carName.length(); i++) {
            char currentLetter = carName.charAt(i);
            if (currentLetter == ',') {
                continue;
            }
            if (currentLetter < 'a' || currentLetter > 'z') {
                throw new IllegalArgumentException();
            }
        }

        String[] carNames = carName.split(",");
        if (carNames.length == 0 || carNames.length > Numbers.MAX_GAME_PLAYER.getNumber()) {
            throw new IllegalArgumentException();
        }
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > Numbers.MAX_NAME_LENGTH.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validatePlayTime(String playtime) {
        if (playtime == null || playtime.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < playtime.length(); i++) {
            char currentLetter = playtime.charAt(i);

            if (currentLetter < '0' || currentLetter > '9') {
                throw new IllegalArgumentException();
            }
        }
        int number = Integer.parseInt(playtime);
        if (number <= 0 || number > Numbers.MAX_GAME_PLAY.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
