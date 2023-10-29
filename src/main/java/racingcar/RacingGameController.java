package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.IllegalNameEmptyException;
import racingcar.Exception.IllegalNameLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingGameController {
    private static final Integer RANDOM_START = 0;
    private static final Integer LIMIT_NAME_LENGTH = 5;
    private static final Integer RANDOM_END = 9;
    private static final Integer RANDOM_BOUNDARY = 4;
    public static Cars createRacingCars() {
        String[] carNames = Console.readLine().trim().split(",");
        validateCarNamesIsEmpty(carNames);
        List<Car> cars = Arrays.stream(carNames)
                .map((carName)->{
                    validateNameLength(carName);
                    return new Car(carName);
                })
                .toList();

        return new Cars(cars);
    }
    private static void validateNameLength(String carName) {
        if (carName.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalNameLengthException();
        }
    }

    private static void validateCarNamesIsEmpty(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalNameEmptyException();
        }
    }

    public static List<String> getWinner(Cars cars) {
        Integer maxPosition = getMaxPosition(cars);
        List<String> returnCarList=new ArrayList<>();
        for(Car car : cars.getCars()){
            if(Objects.equals(car.getPosition(), maxPosition)){
                returnCarList.add(car.getName());
            }
        }
        return returnCarList;
    }
    public static void randomNumber(Car car){
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
