package racingcar.domain;

public class ManualMoveChecker implements MoveChecker {
    private final MoveInstruction moveInstruction;

    public ManualMoveChecker(MoveInstruction moveInstruction) {
        this.moveInstruction = moveInstruction;
    }

    @Override
    public MoveInstruction canMove() {
        return moveInstruction;
    }
}
