package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private final List<Car> racingCars = new ArrayList<>();
    private int carCount = 0;

    public void createCarList() {
        // 입력 받은 값 쉼표 기준으로 나눠서 리스트에 저장
        String[] carNameArray = Console.readLine().split(","); // array말고 바로 리스트에 저장 못 하나...
        for (String carName: carNameArray) {
            Car newCar = new Car(carName);
            racingCars.add(newCar);
            carCount++;
        }
    }
}
