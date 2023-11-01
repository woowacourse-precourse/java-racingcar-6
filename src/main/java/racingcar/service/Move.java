package racingcar.service;

public class Move {

    private static final int MOVE = 1;
    private static final int NOT_MOVE = 0;

    Random random = new Random();

    public int moveOrNot() {
        int isOverFour = random.randomNumber();
        int result;

        if (isOverFour < 4) {
            result = NOT_MOVE;
        } else {
            result = MOVE;
        }

        return result;
    }
}
