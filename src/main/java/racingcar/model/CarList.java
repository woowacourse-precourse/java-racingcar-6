package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }

    public String getForwardStateString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getForwardStateString(car));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String winnersToString() {
        CarList winners = getWinners();
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private CarList getWinners() {
        Car winner1 = carList.stream()
                .max(Comparator.comparingInt(Car::getPosition)).get();
        List<Car> winnerList = carList.stream()
                .filter(car -> car.getPosition() == winner1.getPosition())
                .toList();
        return new CarList(winnerList);
    }
}
