package racingcar;

import java.util.List;

public class FindWinner {
    private List<Car> carList;
    private int winningPoint;

    public FindWinner(List<Car> carList) {
        this.carList = carList;
        this.winningPoint = findWinningPoint();
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        String winner = "";

        for (Car car : carList) {
            if (car.getPosition() == winningPoint) {
                winner += addSpot(winner);
                winner += car.getCarName();
            }
        }
        System.out.println(winner);
    }

    public int getWinningPoint() {
        return winningPoint;
    }

    public int findWinningPoint() {
        int winningPoint = 0;

        for (Car car : carList) {
            if (car.getPosition() > winningPoint) {
                winningPoint = car.getPosition();
            }
        }
        return winningPoint;
    }
    public String addSpot(String winner) {
        if (winner.length() > 0) {
            return ", ";
        }
        return "";
    }
}
