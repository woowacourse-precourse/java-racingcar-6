package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";
    private static final int NAME_LENGTH = 5;
    private final List<Car> cars = new ArrayList<>();

    public void createCars() {
        String[] carNames = inputCarNames();
        for (String carName : carNames) {
            if (isValidCarNameLength(carName)) {
                Car car = new Car(carName);
                cars.add(car);
            } else {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
            }
        }
    }

    private static String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine().split(DELIMITER);
    }

    private static boolean isValidCarNameLength(String carName) {
        return carName.length() <= NAME_LENGTH;
    }
}
