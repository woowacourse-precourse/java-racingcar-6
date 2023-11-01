package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class InputManager {
    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<Car> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String[] carNames = Console.readLine().split(",");
        return convertToCarList(carNames);
    }

    public Integer inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = Console.readLine();
        isValidateTryCount(tryCount);
        return Integer.valueOf(tryCount);
    }


    public void isValidateCarName(String carName, List<Car> cars) {
        if (isBlankCarName(carName)) {
            throw new IllegalArgumentException("INVALID carName : carName is empty");
        } else if (isInvalidCarNameLength(carName)) {
            throw new IllegalArgumentException("INVALID carName : carName length is over then 5");
        } else if (isContainedCarName(carName, cars)) {
            throw new IllegalArgumentException("INVALID carName : carName already exists.");
        }
    }

    private Boolean isBlankCarName(String carName) {
        String pattern = "^\\s*$";
        return carName.matches(pattern);
    }

    private Boolean isInvalidCarNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            return true;
        }
        return false;
    }

    private Boolean isContainedCarName(String carName, List<Car> cars) {
        return cars.stream().anyMatch(car -> car.getCarName().equals(carName));
    }

    public List<Car> convertToCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            isValidateCarName(carName, cars);
            cars.add(new Car(carName));
        }
        return cars;
    }

    public Boolean isValidateTryCount(String tryCount) {
        if (!isNumber(tryCount)) {
            throw new IllegalArgumentException("INVALID tryCount : non-numeric characters");
        } else if (isLessThanOne(Integer.valueOf(tryCount))) {
            throw new IllegalArgumentException("INVALID tryCount : number less than 1");
        }
        return true;
    }

    private Boolean isNumber(String tryCount) {
        return tryCount.matches("[0-9]+");
    }

    private Boolean isLessThanOne(int tryCount) {
        if (tryCount < 1) {
            return true;
        }
        return false;
    }
}
