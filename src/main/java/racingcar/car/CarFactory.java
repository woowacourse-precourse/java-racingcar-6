package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CarFactory {
private CarFactory() {
    }

    private static final Pattern specialCharacterPattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");
    private static final String CAR_SEPARATOR = ",";
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final String LIMIT_LENGTH_EXCEPTION_MESSAGE = "이름은 5자 이하로 입력해주세요.";
    private static final String SPECIAL_CHARACTER_EXCEPTION_MESSAGE = "이름에 특수문자는 사용할 수 없습니다.";

    public static List<Car> createCar(String name) {
        List<String> names = splitCarName(name);
        for (String carName : names) {
            validateName(carName);
        }

        List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(Car.createCar(carName));
        }

        return cars;
    }

    private static List<String> splitCarName(String name) {
        return List.of(name.split(CAR_SEPARATOR));
    }

    private static void validateName(String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(LIMIT_LENGTH_EXCEPTION_MESSAGE);
        }

        if (specialCharacterPattern.matcher(name).find()) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_EXCEPTION_MESSAGE);
        }
    }
}
