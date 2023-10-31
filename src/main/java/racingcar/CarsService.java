package racingcar;

import static racingcar.Car.makeCar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CarsService {
    public static Map<Car, Integer> makeCars(String userInput) {
        Map<Car, Integer> cars = new HashMap<>();
        String[] carsArray = Arrays.stream(userInput.split(",")) // 입력 내용 ,기준으로 공백 제거해서 배열에 저장
                .map(String::trim).toArray(String[]::new);

        for (String candidateCar : carsArray) {
            Car car = makeCar(candidateCar);
            cars.put(car, 0);
        }
        return cars;
    }

    public static int updateCount(Map<Car, Integer> cars, Car car) {
        int updateCount = cars.get(car) + 1;
        return updateCount;
    }
}
