package racingcar.dto;

public class MoveCountRequest {
    private final int moveCount;

    public MoveCountRequest(final int moveCount){
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
