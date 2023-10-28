package racingcar.domain;

public class Judgment {
    private final int BOUNDARY_NUMBER = 4;

    public boolean canMove(int number) {
        return number >= BOUNDARY_NUMBER;
    }
}
