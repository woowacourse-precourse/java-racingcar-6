package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private RandomUtil randomUtil;
    private final List<String> carNameList;
    private List<Car> carList = new ArrayList<>();
    private List<String> maxPositionCarList = new ArrayList<>();

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

    public void move() {
        for (Car car : carList) {
            car.move();
        }
    }

    public List<String> createMaxPositionCarList() {
        int maxPosition = findMaxPosition();
        for (Car car : carList) {
            addMaxPositionCar(maxPosition, car);
        }
        return maxPositionCarList;
    }

    private Integer findMaxPosition() {
        int maxPosition = -1;
        for (Car car : carList) {
            Integer position = car.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    private void addMaxPositionCar(int maxPosition, Car car) {
        if (maxPosition == car.getPosition()) {
            maxPositionCarList.add(car.getName());
        }
    }
}
