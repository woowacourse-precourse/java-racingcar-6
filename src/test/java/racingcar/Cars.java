package racingcar;

import static racingcar.Car.makeCar;

import java.awt.image.TileObserver;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cars { // HashMap 형태로 Car 저장
    private final Map<Car, Integer> cars;

    public Cars(Map<Car, Integer> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(String userInput) {
        Map<Car, Integer> carsMap = new HashMap<>();
        String[] carsArray = Arrays.stream(userInput.split(",")) // 입력 내용 ,기준으로 공백 제거해서 배열에 저장
                .map(String::trim)
                .toArray(String[]::new);

        for (String candidateCar : carsArray) {
            Car car = makeCar(candidateCar);
            carsMap.put(car, 0);
        }

        return new Cars(carsMap);
    }
}
