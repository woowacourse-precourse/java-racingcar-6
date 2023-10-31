package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();

    public void createCars() {
        try {
            String[] carNames = inputCarNames();
            for (String carName : carNames) {
                Car car = new Car(carName);
                cars.add(car);
            }
        } catch (IllegalArgumentException e) {
            createCars();
        }
    }

    private static String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine().split(DELIMITER);
    }
}
