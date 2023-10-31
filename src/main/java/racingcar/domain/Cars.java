package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        validateDuplicateCar(carList);
        this.carList = carList;
    }

    private void validateDuplicateCar(List<Car> carList) {
        long distinctCarCount = carList.stream()
                .distinct()
                .count();

        if (distinctCarCount != carList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void moveCars() {
        carList.stream().forEach(x -> x.moveWithRandomNumber());
    }

}
