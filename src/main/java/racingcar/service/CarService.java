package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.CarView;

public class CarService {

    private CarService() {
    }

    public static CarService getInstance() {
        return CarService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final CarService INSTANCE = new CarService();
    }

    private boolean canGo() {
        int pickNumber = Randoms.pickNumberInRange(0, 9);
        return pickNumber >= 4;
    }

    synchronized private void driveCar(Car car) {
        int distance = car.getDistance();
        if (canGo()) {
            distance++;
        }
        car.setDistance(distance);
    }

    public void updateView(Car car, boolean isLast) {
        CarView carView = CarView.getInstance();
        driveCar(car);
        carView.printCarStatus(car.getName(), car.getDistance(), isLast);
    }
}
