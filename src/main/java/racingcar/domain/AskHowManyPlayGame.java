package racingcar.domain;

public class AskHowManyPlayGame {
    public int askHowManyPlayGame(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
