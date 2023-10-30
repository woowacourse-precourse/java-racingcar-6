package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.Car;
import racingcar.Domain.CarGroup;

public class GameModelImpl implements GameModel {
    public CarGroup playGameRound(CarGroup carGroup) {
        for (int order = 1; order <= carGroup.findSize(); order++) {
            Car findCar = carGroup.findCarByOrder(order);
            if (Boolean.TRUE.equals(determineMove())) {
                findCar.updatePosition();
            }
        }
        return carGroup;
    }

    public Boolean determineMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }
}
