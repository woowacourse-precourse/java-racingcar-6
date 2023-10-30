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
        createCarList();
    }

    public void createCarList() {
        for (String carName : carNameList) {
            carList.add(new Car(carName, 0, randomUtil));
        }
    }

    public void move() {
        for (Car car : carList) {
            car.move();
        }
    }

    public String translateRacingCarResult() {
        StringBuilder translatedResult = new StringBuilder();
        int size = carList.size();
        for (int carNumber = 0; carNumber < size; carNumber++) {
            Car car = carList.get(carNumber);
            translatedResult
                    .append(car.getName())
                    .append(" : ")
                    .append(translatePosition(car.getPosition()))
                    .append(newLine(carNumber));
        }
        return translatedResult.toString();
    }

    private String translatePosition(int position) {
        if (position == 0) {
            return "";
        }
        return "-".repeat(position);
    }

    private String newLine(int carNumber) {
        if (carNumber != carList.size() - 1) {
            return "\n";
        }
        return "";
    }

    public String translateMaxPositionCars() {
        int maxPosition = findMaxPosition();
        StringBuilder translatedMaxPositionCars = new StringBuilder();
        for (int i = 0; i < carList.size(); i++) {
            translatedMaxPositionCars
                    .append(findMaxPositionCar(maxPosition, carList.get(i)))
                    .append(addComma(i));
        }
        return translatedMaxPositionCars.toString();
    }

    private Integer findMaxPosition() {
        int maxPosition = -1;
        for (Car car : carList) {
            Integer position = car.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    private String findMaxPositionCar(int maxPosition, Car car) {
        if (maxPosition == car.getPosition()) {
            return car.getName();
        }
        return "";
    }

    private String addComma(int index) {
        if (index == carList.size() - 1) {
            return "";
        }
        return ", ";
    }
}
