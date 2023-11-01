package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private InputHandler inputHandler = new InputHandler();
    private List<Car> carList = new ArrayList<>();
    private int count;

    private void initializeGame() {
        carList = registCarList(inputHandler.inputCarName());
        count = inputHandler.inputMatchCount();
    }

    public void play() {
        initializeGame();
        for (int i = 0; i < count; i++) {
            moveAllCar(carList);
        }
        announceWinner(carList);
    }

    private List<Car> registCarList(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name: carNameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void moveAllCar(List<Car> cars) {
        for (Car car: cars) {
            car.move();
            System.out.println(car.getMoveResult());
        }
    }

    private void announceWinner(List<Car> cars) {
        List<String> winnerList = registWinner(cars);
        int winnerSize = winnerList.size();
        System.out.print("최종 우승자 : ");
        if (winnerSize == 1) {
            System.out.print(winnerList.get(0));
        } else {
            for (int i = 0; i < winnerSize; i++) {
                System.out.print(winnerList.get(i));
                if (i < winnerSize - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

    private List<String> registWinner(List<Car> cars) {
        List<String> winnerList = new ArrayList<>();
        int max = -1;
        for (Car car: cars) {
            if (car.getMoveAmount() > max) {
                max = car.getMoveAmount();
                winnerList.clear();
                winnerList.add(car.getName());
            } else if (car.getMoveAmount() == max) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

}
