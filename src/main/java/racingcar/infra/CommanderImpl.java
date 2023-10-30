package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Commander;
import racingcar.domain.MoveCarType;
import racingcar.domain.MoveCommandMaker;

public class CommanderImpl implements Commander {

    public CommanderImpl() {
    }

    @Override
    public void moveCar(Car car, MoveCommandMaker moveCommandMaker) {
        int randomNumber = Randoms.pickNumberInRange(0,9);

        car.move(moveCommandMaker.makeMoveCommand(randomNumber));
    }
}
