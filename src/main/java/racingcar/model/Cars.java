package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> carsList;

    public Cars(List<Car> carsList) {
        this.carsList = (carsList);
    }

    public int size() {
        return carsList.size();
    }

    public Car getCarInIndex(int index) {
        return carsList.get(index);
    }

    public int getMaxMoveInCars() {
        int maxMove = 0;
        for (Car car : carsList) {
            maxMove = Integer.max(maxMove, car.getMove());
        }
        return maxMove;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carsList) {
            sb.append(car);
            sb.append("\n");
        }
        return sb.toString();
    }
}
