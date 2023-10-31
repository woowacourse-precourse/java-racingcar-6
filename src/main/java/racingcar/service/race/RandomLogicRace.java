package racingcar.service.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RandomLogicRace implements Racing{
    private static final int MOVE_NUMBER = 4;
    @Override
    public void race(final Cars cars) {
        driveCars(cars);

    }
    private static void driveCars(final Cars cars) {
        for(Car car: cars.getCarList()){
            move(car, Randoms.pickNumberInRange(0, 9));
        }
    }
    private static void move(final Car car, final int value) {
        if(checkValuableNumber(value)){
            car.updatePosition();
        }
    }
    private static boolean checkValuableNumber(final int value) {
        return value >= MOVE_NUMBER;
    }
}
