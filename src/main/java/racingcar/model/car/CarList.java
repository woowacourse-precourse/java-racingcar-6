package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private RandomUtil randomUtil;
    private final List<String> carNameList;
    private List<Car> carList = new ArrayList<>();

    public CarList(List<String> carNameList, RandomUtil randomUtil) {
        this.carNameList = carNameList;
        this.randomUtil = randomUtil;
        initializeCarList();
    }

    public void initializeCarList() {
        for (String carName : carNameList) {
            carList.add(new Car(carName.trim(), 0, randomUtil));
        }
    }

    public void move() {
        for (Car car : carList) {
            car.move();
        }
    }

    public String showCarList() {
        StringBuilder translatedResult = new StringBuilder();
        int size = carList.size();
        for (Car car : carList) {
            translatedResult
                    .append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return translatedResult.toString();
    }

    public List<String> findMaxPositionCars() {
        int maxPosition = findMaxPosition();
        List<String> maxPositionCarList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                maxPositionCarList.add(car.getName());
            }
        }
        return maxPositionCarList;
    }

    public Integer findMaxPosition() {
        int maxPosition = -1;
        for (Car car : carList) {
            Integer position = car.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }
}
