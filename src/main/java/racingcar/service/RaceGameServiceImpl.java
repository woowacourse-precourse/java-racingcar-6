package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceGameServiceImpl implements RaceGameService{

    private static final int MORE_THAN_NUMBER = 4;
    private static final int START_RANDOM_NUMBER_RANGE = 0;
    private static final int FINISH_RANDOM_NUMBER_RANGE = 9;

    @Override
    public void carMoveCheckAndGo(Car car) {
        // 전진하는 조건은 0~9사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우
        List<Integer> carPositions = car.getCarPosition();
        carMoveCheck(car, carPositions);
    }

    private static void carMoveCheck(Car car, List<Integer> carPositions) {
        for (int i=0; i<carPositions.size(); i++) {
            if (getRandomValue() >= MORE_THAN_NUMBER) {
                car.carMove(i);
            }
        }
    }

    private static int getRandomValue() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER_RANGE, FINISH_RANDOM_NUMBER_RANGE);
    }

    @Override
    public List<Integer> findWinner(Car car) {
        int maxPosition = findMaxPosition(car);
        return findWinnerIndex(car, maxPosition);
    }

    private static List<Integer> findWinnerIndex(Car car, int maxPosition) {
        List<Integer> carPositions = car.getCarPosition();

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<carPositions.size(); i++) {
            if (carPositions.get(i) == maxPosition) {
                result.add(i);
            }
        }
        return result;
    }

    private static int findMaxPosition(Car car) {
        List<Integer> carPositions = car.getCarPosition();

        int maxPosition = 0;

        for (Integer carPosition : carPositions) {
            if (carPosition > maxPosition) {
                maxPosition = carPosition;
            }
        }
        return maxPosition;
    }
}
