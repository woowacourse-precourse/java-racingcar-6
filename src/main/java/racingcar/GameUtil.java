package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class GameUtil {
    private static final int ADVANCE_NUMBER = 4;
    private static final int RANDOM_NUMBER_RANGE = 9;
    public static List<Car> getCarList(String input) {
        String[] carNames = input.split(",");
        List<Car> carList = new ArrayList<>();
        for (String car : carNames) {
            carList.add(new Car(car));
        }
        return carList;
    }

    public static boolean isMoveCondition() {
        //랜덤으로 뽑은 임의의 숫자가 4보다 클 경우 true 반환
        int randomInt = ThreadLocalRandom.current().nextInt(RANDOM_NUMBER_RANGE) + 1;
        return randomInt >= ADVANCE_NUMBER;
    }
    public static List<String> getNameListWithPosition(int position, List<Car> carList) {
        return carList.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
