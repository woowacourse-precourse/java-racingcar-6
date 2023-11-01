package racingcar.domain;

import java.util.List;

public class InputValidator {
    public static boolean isPositiveNumber(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        try {
            // 입력 문자열을 정수로 파싱하고 양수 여부를 판단
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            // 정수로 파싱할 수 없는 경우 (예: 숫자가 아닌 문자열)
            return false;
        }
    }
    // 입력받은 차량이 모두 이름을 가지는지 확인 (빈 문자열 이름이 없는지)
    public static boolean isValidateCars(List<Car> cars) {
        for (Car car : cars) {
            String name = car.name;
            if (name == null || name.isEmpty() || name.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
