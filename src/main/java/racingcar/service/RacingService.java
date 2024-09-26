package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public List<Car> playRound(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 10);
            car.move(randomNumber);
        }

        return carList;
    }

    public int getMaxMovingDistance(List<Car> carList) {
        int maxMovingDistance = Integer.MIN_VALUE;

        for (Car car : carList) {
            int carLocation = car.getMovingDistance();
            if (carLocation > maxMovingDistance) {
                maxMovingDistance = carLocation;
            }
        }

        return maxMovingDistance;
    }

    public List<String> generateWinnerList(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();

        int maxMovingDistance = getMaxMovingDistance(carList);

        for (Car car : carList) {
            int curLocation = car.getMovingDistance();
            if (curLocation == maxMovingDistance) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
