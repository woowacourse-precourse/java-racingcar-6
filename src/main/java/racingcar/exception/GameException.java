package racingcar.exception;

public class GameException {
    public void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public int checkInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit((input.charAt(i)))) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(input);
    }
}
