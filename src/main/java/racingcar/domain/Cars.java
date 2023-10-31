package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(){
        for(Car car : cars){
            car.moveByRandomNumber();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
    
    public List<String> getWinnerNameList() {
        int maxPosition = getMaxPosition();
        return getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : getCars()) {
            if (car.getPosition() > maxPosition)
                maxPosition = car.getPosition();
        }
        return maxPosition;
    }




}
