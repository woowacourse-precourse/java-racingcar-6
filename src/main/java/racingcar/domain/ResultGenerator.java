package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public void printFinalResult(List<String> winnerList) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자 : ");
        String winners = String.join(",", winnerList);
        sb.append(winners);

        System.out.println(sb);
    }
}
