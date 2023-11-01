package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ResultGenerator {
    public void playRound(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 10);
            car.move(randomNumber);
            String carStatus = car.getStatus();
            System.out.println(carStatus);
        }
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
        return null;
    }

    public void printFinalResult(List<String> winnerList) {
    }
}
