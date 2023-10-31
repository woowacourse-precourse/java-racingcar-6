package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> carList = new ArrayList<>();

    public void moveCars() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            carList.get(i).moves(randomNumber);
        }
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getWinners() {
        int maxLocation = findMaxLocation();
        return findSameLocationCars(maxLocation);
    }

    public List<Car> findSameLocationCars(int location) {
        List<Car> cars = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocation() == location) {
                cars.add(car);
            }
        }
        return cars;
    }

    public int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : carList) {
            int carLocation = car.getLocation();
            if (carLocation > maxLocation) {
                maxLocation = carLocation;
            }
        }
        return maxLocation;
    }


    public List<Car> getCarList() {
        return carList;
    }
}
