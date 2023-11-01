package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validate {

    public static void checkEmpty(String[] input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다");
        }
    }

    public static List<Car> validateCarName(String[] inputs) {
        checkEmpty(inputs);
        List<Car> cars = new ArrayList<>();
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            Car car = new Car(input);
            cars.add(car);
        }
        return cars;
    }

    public static int checkNumber(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return result;
    }
}