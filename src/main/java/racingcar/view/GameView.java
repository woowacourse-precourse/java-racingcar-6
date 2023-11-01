package racingcar.view;

public class GameView {
    public static void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
