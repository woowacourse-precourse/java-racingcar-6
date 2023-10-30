package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.MoveCarType;
import racingcar.domain.MoveCommandMaker;

public class MoveCommandMakerImpl implements MoveCommandMaker {
    @Override
    public MoveCarType makeMoveCommand() {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        if (randomNumber >= 4) {
            return MoveCarType.FORWARD;
        }
        else {
            return MoveCarType.STOP;
        }
    }
}
