package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .filter(car -> !car.getName().isEmpty())
                .peek(RacingGameController::validateNameLength)
                .toList();
        return new Cars(cars);
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
    public static void randomDice(Car car){
        int randomValue = pickNumberInRange(RANDOM_START, RANDOM_END);
        if(randomValue >= RANDOM_BOUNDARY){
            car.setPosition(car.getPosition() + 1);
        }
    }

    private static void validateNameLength(Car car) {
        if (car.getName().length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
