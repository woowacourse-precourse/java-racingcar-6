package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public enum CarRepository {
    INSTANCE;
    private final List<Car> carList = new ArrayList<Car>();

    public void clearCarList() {
        carList.clear();
    }

    public void addCar(List<String> nameList) {
        for(String name : nameList) {
            carList.add(new Car(name));
        }
    }

    public void go() {
        for(Car car : carList) {
            car.go();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinners() {
        int numberWin = winnerScore();
        List<Car> winners = new ArrayList<Car>();

        for (Car car : carList) {
            if (car.getGo() == numberWin) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int winnerScore() {
        int result = 0;
        for(Car car : carList) {
            int carGo = car.getGo();
            if(result < carGo) {
                result = carGo;
            }
        }
        return result;
    }
}
