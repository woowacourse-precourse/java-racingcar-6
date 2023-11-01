package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> winnerList;
    private String winner;

    public Result() {
    }

    public int getLeaderDistance(List<Car> carList) {
        int leaderDistance = carList.stream().map(Car::getState).mapToInt(String::length).max().getAsInt();
        return leaderDistance;
    }

    public void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.printf("%s : %s\n", car.getName(), car.getState());
        }
        System.out.println();
    }

    public void printWinner() {
        System.out.println("최종 우승자 : " + winner);
    }

    public void decideWinner(List<Car> carList, int leaderDistance) {
        winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getState().length() == leaderDistance) {
                winnerList.add(car.getName());
            }
        }
        winner = String.join(", ", winnerList);
    }
}
