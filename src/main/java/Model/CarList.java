package Model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getSize() {
        return carList.size();
    }

    public Car getCar(int idx) {
        return carList.get(idx);
    }

    public CarList calculateRaceWinners() {
        CarList raceWinners = new CarList();

        int maxPosition = 0;
        for (Car car : carList) {
            CarPosition carPosition = car.getPosition();
            int position = carPosition.getCarPosition();
            if (maxPosition < position) {
                maxPosition = position;
            }
        }

        for (Car car : carList) {
            CarPosition carPosition = car.getPosition();
            int position = carPosition.getCarPosition();
            if (maxPosition == position) {
                raceWinners.addCar(car);
            }
        }

        return raceWinners;
    }

    public void printCarNames() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.printCarName();
            if (i != carList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
