package racingcar.car;

import java.util.List;
import racingcar.util.CarListMaker;

public record Cars(List<Car> carList) {
    public static Cars fromNames(String names) {
        CarListMaker carListMaker = new CarListMaker();
        return new Cars(carListMaker.makeCarList(names));
    }

    public void race(List<Integer> numberList) {
        for (int index = 0; index < numberList.size(); index++) {
            Car car = carList.get(index);
            int randomNumber = numberList.get(index);
            car.moveForward(randomNumber);
        }
    }

    public List<Car> findWinners() {
        return carList.stream()
                .filter(this::isWinner)
                .toList();
    }

    private int getMaxLocation() {
        return carList.stream()
                .mapToInt(Car::getCarLocation)
                .max()
                .orElse(0);
    }

    private boolean isWinner(Car car) {
        return car.getCarLocation() == getMaxLocation();
    }

    public int totalCars() {
        return carList.size();
    }
}
