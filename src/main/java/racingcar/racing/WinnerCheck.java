package racingcar.racing;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerCheck {
    private final String winner = "최종 우승자 : ";
    private List<Car> carList;
    private int max = -1;
    private List<String> winners;

    public WinnerCheck(List<Car> carList) {
        this.carList = carList;
        this.winners = new ArrayList<>();
    }

    public void getWinner() {
        selectMax();
        chooseWinner();
        printWinners();
    }

    private void printWinners() {
        System.out.printf("%s", winner);
        for (String name : winners) {
            System.out.printf("%s ", name);
        }
    }

    private void chooseWinner() {
        for (Car car : carList) {
            if (car.getPosition() == this.max) {
                winners.add(car.getName());
            }
        }
    }

    private void selectMax() {
        for (int i = 0; i < carList.size(); i++) {
            int current = carList.get(i).getPosition();
            if (current > max) {
                this.max = current;
            }
        }
    }
}
