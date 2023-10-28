package racingcar.domain;

public class AskHowManyPlayGame {
    public int askHowManyPlayGame(String input) {
        try {
            int result = Integer.parseInt(input);

            if (result <= 0 ) {
                throw new IllegalArgumentException();
            } else {
                return result;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
