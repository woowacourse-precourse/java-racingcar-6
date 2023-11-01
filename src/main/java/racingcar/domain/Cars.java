package racingcar.domain;

import racingcar.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final String DELIMITER = ",";
    private final int MIN_RANDOM_NUMBER = 1;
    private final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars = new ArrayList<>();

    public Cars(String input){
        List<String> carNames =  Arrays.asList(input.split(DELIMITER));
        validateDuplicateName(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move(){
        for(Car car : cars){
            car.move(Utils.generateNumber(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER + 1));
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    private void validateDuplicateName(List<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }
}
