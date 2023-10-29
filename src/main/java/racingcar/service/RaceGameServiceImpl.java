package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.CarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceGameServiceImpl implements RaceGameService{

    private static final int MORE_THAN_NUMBER = 4;

    @Override
    public Car startGame(List<String> input) {
        Car car = new Car();
        car.initCar(input);
        return car;
    }

    @Override
    public void carMoveCheckAndGo(Car car) {
        // 전진하는 조건은 0~9사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우
        carMoveCheck(car, car.getCarSize());
    }

    private static void carMoveCheck(Car car, int size) {
        for (int i=0; i<size; i++) {
            if (isCanMove()) {
                car.carMove(i);
            }
        }
    }

    private static boolean isCanMove() {
        return CarUtil.getRandomValue() >= MORE_THAN_NUMBER;
    }

    @Override
    public List<Integer> findWinner(Car car) {
        int maxPosition = car.findMaxPosition();
        return car.findWinnerIndex(maxPosition);
    }

}
