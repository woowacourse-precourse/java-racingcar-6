package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class utils {
    public static List<String> convertToList(String value) {
        try {
            return Arrays.asList(value.split(","));
        } catch (Exception e){
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    public static void checkCarNameUnderFiveLength(List<String> strings){
        for (String s: strings){
            if (s.length() > 5){
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }
        }
    }

    public static int convertToInteger(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    public static List<Car> findCarsWithMaxDistance(List<Car> carList){
        List<Car> maxDistanceCars = new ArrayList<>();
        if (carList.isEmpty()) {
            return maxDistanceCars;
        }

        int maxDistance = Integer.MIN_VALUE;

        for (Car car : carList) {
            if (car.getDistance() > maxDistance) {
                maxDistanceCars.clear();
                maxDistanceCars.add(car);
                maxDistance = car.getDistance();
            } else if (car.getDistance() == maxDistance) {
                maxDistanceCars.add(car);
            }
        }

        return maxDistanceCars;
    }
}
