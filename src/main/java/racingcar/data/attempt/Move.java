package racingcar.data.attempt;

public enum Move {
    STOP(0),
    FORWARD(1);

    private final int move;
    private static final String WRONG_MOVE_EXCEPTION = "Moves should be ";
    
    Move(int move) {
        this.move = move;
    }

    public static int getNumByMove(int moveResult) {
        for (Move move : Move.values()) {
            if (move.getMove() == moveResult) {
                return move.getMove();
            }
        }
        throw new IllegalArgumentException(WRONG_MOVE_EXCEPTION + STOP.getMove() + " or " + FORWARD.getMove() + ".");
    }

    public int getMove() {
        return move;
    }
}
