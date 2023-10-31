package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<>();

    public CarList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        carNameList.forEach(carName -> {
            Car car = new Car(carName);
            isDuplicate(car);
            carList.add(car);
        });
    }

    private void isDuplicate(Car car) {
        if(carList.contains(car)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<Car> getCarList() {
        return List.copyOf(this.carList);
    }

    public String move() {
        this.carList.forEach(Car::move);
        return this.toString();
    }

    public String calculateWinners() {
        List<String> winners = new ArrayList<>();

        carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
        int maxPosition = carList.get(0).getPosition();

        carList.forEach(car -> {
            if(car.getPosition() == maxPosition) {
                winners.add(car.carNameToString());
            }
        });
        return makeWinnersString(winners);
    }

    private String makeWinnersString(List<String> winners) {
        return String.join(", ", winners);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
