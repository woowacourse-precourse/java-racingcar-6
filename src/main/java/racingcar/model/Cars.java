package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.InputValidator;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        InputValidator.validateCarNames(names);
        cars = generateCars(names);
    }

    private List<Car> generateCars(String names) {
        List<Car> carList = new ArrayList<>();
        String[] carNamesArray = names.replace(" ", "").split(",");
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void decideToMove() {
        cars.forEach(Car::decideToMove);
    }

    public String generateRoundResultString() {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.getDisplayFormat());
            sb.append("\n");
        });
        return sb.toString();
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> maxPosition == car.getCarPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

}
