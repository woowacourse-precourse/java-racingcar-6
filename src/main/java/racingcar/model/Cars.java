package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> carsList;

    public Cars(List<Car> carsList) {
        this.carsList = (carsList);
    }

    public int size() {
        return carsList.size();
    }

    public Car getCarInIndex(int index) {
        return carsList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Car car : carsList) {
            sb.append(car);
            sb.append("\n");
        }
        return sb.toString();
    }
}
