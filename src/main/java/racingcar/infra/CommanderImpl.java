package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Commander;
import racingcar.domain.MoveCarType;

public class CommanderImpl implements Commander {
    @Override
    public void moveCar(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        if (randomNumber >= 4) {
            car.move(MoveCarType.FORWARD);
        }
        else {
            car.move(MoveCarType.STOP);
        }

    }
}
