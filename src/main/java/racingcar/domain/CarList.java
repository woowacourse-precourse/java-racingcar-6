package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static racingcar.Constant.*;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        for (Car car : carList) {
            if (isMove()) {
                car.move();
            }
        }
    }

    private boolean isMove() {
        int number = Randoms.pickNumberInRange(START, END);
        return number >= MOVING_FORWARD;
    }

    public void printWinners() {
        List<String> winnerList = getWinnerList();

        String winners = String.join(OUTPUT_DELIM, winnerList);
        System.out.print(MESSAGE_WINNER + IS + winners);
    }

    private List<String> getWinnerList() {
        int winnerPoint = getWinnerPoint();

        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (isWinner(car, winnerPoint)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private int getWinnerPoint() {
        int winnerPoint = 0;
        for (Car car : carList) {
            winnerPoint = max(winnerPoint, car.getPoint());
        }
        return winnerPoint;
    }

    private boolean isWinner(Car car, int winnerPoint) {
        return car.getPoint() == winnerPoint;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Car car : carList) {
            builder.append(car);
            builder.append("\n");
        }
        return builder.toString();
    }

}
