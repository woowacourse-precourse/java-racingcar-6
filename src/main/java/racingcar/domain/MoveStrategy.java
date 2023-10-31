package racingcar.domain;

public class MoveStrategy {

    private final Distance nextDistance;

    public MoveStrategy(Distance nextDistance) {
        this.nextDistance = nextDistance;
    }

    public Distance move(Distance before, Navigator navigator) {
        return addDistance(before, navigator.decideMoveAction());
    }

    private Distance addDistance(Distance before, MoveAction moveAction) {
        if (moveAction.equals(MoveAction.GO)) {
            return before.increase(nextDistance);
        }
        return before;
    }
}
