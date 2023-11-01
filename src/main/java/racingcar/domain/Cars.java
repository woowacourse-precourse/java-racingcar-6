package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        checkDuplicateCarName(carNames);

        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners(){
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return new Winners(winners);
    }
    public int getMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : getCars()){
            if (car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
    public static void checkDuplicateCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
