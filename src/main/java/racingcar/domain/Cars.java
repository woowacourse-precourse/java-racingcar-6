package racingcar.domain;

import racingcar.view.InputView;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(String carNames) {
        this.cars = carList(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void carMove(CarMoveCondition carMoveCondition) {

        for (Car car : this.cars) {
            if (carMoveCondition.moveCondition()) {
                car.move();
            }
        }
    }

    public List<Car> carList(String cars) {

        List<Car> carsList = Arrays.stream(cars.split(InputView.COMMA))
                .map(Car::new)
                .toList();

        long duplicateNameRemoveLength = carsList.stream()
                .map(Car::getCarName)
                .distinct()
                .count();

        DuplicateCarName(carsList, duplicateNameRemoveLength);

        return carsList;
    }

    public Cars winners() {

        final List<Car> winners = new ArrayList<>(this.cars).stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .toList();

        int winnerPosition = winners.get(0).getPosition();

        return new Cars(winners.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .toList());
    }

    private void DuplicateCarName(List<Car> cars,
                                  long size) {

        if (cars.size() != size) {
            throw new IllegalArgumentException();
        }
    }
}
