package racingcar.domain.system.game.round.host;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.core.car.MoveSignal;
import racingcar.support.SystemProperty;

public class RandomSignalHost extends Host {

    private static final int MIN_SIGNAL = SystemProperty.MIN_RANDOM_NUMBER;
    private static final int MAX_SIGNAL = SystemProperty.MAX_RANDOM_NUMBER;

    @Override
    protected MoveSignal getSignal() {
        int signal = Randoms.pickNumberInRange(MIN_SIGNAL, MAX_SIGNAL);
        return MoveSignal.of((long) signal);
    }
}
