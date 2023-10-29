package service;

import camp.nextstep.edu.missionutils.Randoms;
import repository.CarListRepository;

public class RandomMovementDecider {
    public static boolean moveDecide() {
        int randomPick =  Randoms.pickNumberInRange(0, 9);
        if(randomPick >= 4) {
            return true;
        }
        return false;
    }

    public static void decideForwardMovement(CarListRepository carListRepository) {
        carListRepository.carList.forEach((key, value) -> {
            if (RandomMovementDecider.moveDecide()) {
                carListRepository.forwardCar(key);
            }
        });
    }

}
