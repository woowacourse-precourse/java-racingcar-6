package racingcar.domain.formula;

public class MockFormula implements Formula {

    private final MoveState moveState;

    public MockFormula(MoveState moveState) {
        this.moveState = moveState;
    }

    public MoveState move() {
        return moveState;
    }
}
