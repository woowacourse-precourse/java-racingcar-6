package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.MoveCarType;
import racingcar.domain.MoveCommandMaker;

public class MoveCommandMakerImpl implements MoveCommandMaker {
    @Override
    public MoveCarType makeMoveCommand(int numberForMoveType) {
        if (numberForMoveType >= 4) {
            return MoveCarType.FORWARD;
        }
        else {
            return MoveCarType.STOP;
        }
    }
}
