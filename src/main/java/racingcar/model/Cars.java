package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> cars;
    public Cars() {
        this.cars = new ArrayList<>();
    }
    public List<Car> getCars() {
        return cars;
    }

    public void initCars(Names names) {
        Set<String> carNames = names.getNames();

        for (String carName : carNames) {
            Car car = new Car();
            car.setCarName(carName);
            cars.add(car);
        }
    }
    public void getRandomGameNumber() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.setNumber(randomNumber);
        }
    }
    public void processGameNumber() {
        for (Car car : cars) {
            if (car.getNumber() >= 4)
                car.forward();
        }
    }
    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();

        for (Car car : cars) {
            if (car.getForwardDistance() == maxDistance)
                winners.add(car.getCarName());
        }

        return winners;
    }
    private int getMaxDistance(){
        int maxDistance = -1;

        for (Car car : cars)
            maxDistance = Math.max(car.getForwardDistance(), maxDistance);

        return maxDistance;
    }
}
