package racingcar;

import java.util.List;

public class CheckInput extends Player {
    public static void checkLength(List<RacingCar> player) {
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (player.get(i).name.length() < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkIsUnique(String input, List<RacingCar> player) {
        for (int i = 0; i < player.size(); i++) {
            if (input.equals(player.get(i).name)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkIsMultiple(List<RacingCar> player) {
        if (player.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsNaturalNumber(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
    }
}
