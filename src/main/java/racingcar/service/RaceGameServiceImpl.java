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
        List<Integer> carPositions = car.getCarPosition();
        carMoveCheck(car, carPositions);
    }

    private static void carMoveCheck(Car car, List<Integer> carPositions) {
        for (int i=0; i<carPositions.size(); i++) {
            if (CarUtil.getRandomValue() >= MORE_THAN_NUMBER) {
                car.carMove(i);
            }
        }
    }

    @Override
    public List<Integer> findWinner(Car car) {
        int maxPosition = car.findMaxPosition();
        return car.findWinnerIndex(maxPosition);
    }

}
