package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import racingcar.validator.InputValidator;

public class RacingGameService {
    private static final Integer RANDOM_START = 0;
    private static final Integer RANDOM_END = 9;
    private static final Integer RANDOM_BOUNDARY = 4;
    public static Cars createRacingCars(String[] carNamesList){
        InputValidator.validateCarNamesIsEmpty(carNamesList);
        List<Car> cars = Arrays.stream(carNamesList)
                .map((carName)->{
                    InputValidator.validateNameLength(carName);
                    return new Car(carName);
                })
                .toList();

        return new Cars(cars);
    }
    public List<String> getWinner(Cars cars) {
        Integer maxPosition = getMaxPosition(cars);
        List<String> returnCarList=new ArrayList<>();
        for(Car car : cars.getCars()){
            if(Objects.equals(car.getPosition(), maxPosition)){
                returnCarList.add(car.getName());
            }
        }
        return returnCarList;
    }
    public void randomNumber(Car car){
        int randomValue = pickNumberInRange(RANDOM_START, RANDOM_END);
        if(randomValue >= RANDOM_BOUNDARY){
            car.setPosition(car.getPosition() + 1);
        }
    }
    public static Integer getMaxPosition(Cars cars){
        Integer maxPosition = 0;
        for(Car car : cars.getCars()){
            if(car.getPosition() >= maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
