package racingcar.domain;

public interface MoveCommandMaker {
    MoveCarType makeMoveCommand(int numberForMoveType);
}
