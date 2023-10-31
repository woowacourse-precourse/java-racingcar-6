package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static List<Car> carList = new ArrayList<>();
    private final String name;
    private int position = 0;
    public static int maxPosition = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void addCarList(Car car) {
        carList.add(car);
    }

    private void move() {
        position++;
    }

    public static void canMove(Car car) {
        int randomNum = Randoms.pickNumberInRange(0,9);
        if (randomNum >= 4) {
            car.move();
        }
    }

    private static int getMaxPosition() {
        for(Car car : carList) {
            if(car.position > maxPosition) {
                maxPosition = car.position;
            }
        }
        return maxPosition;
    }

    private static List<String> winnerList() {
        List<String> winnerList = new ArrayList<>();
        for(Car car : carList) {
            if(car.position == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public static void getWinner() {
        getMaxPosition();
        winnerList();
        OutputView.printWinner(winnerList());
    }
}
