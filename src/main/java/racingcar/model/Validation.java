package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void name(List<Cars> cars) {
        nameLimitLength(cars);
        nameNoDuplicate(cars);
        nameMustSize(cars);
    }

    private static void nameLimitLength(List<Cars> cars) {
        for (Cars car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("이름은 5자리 이하만 가능");
            }
        }
    }

    private static void nameNoDuplicate(List<Cars> cars) {
        Set<String> set = new HashSet<>();

        for (Cars car : cars) {
            set.add(car.getName());
        }

        if (set.size() != cars.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다");
        }
    }

    private static void nameMustSize(List<Cars> cars) {
        if (cars.size() < 1) {
            throw new IllegalArgumentException("한 대 이상의 자동차가 있어야 합니다.");
        }
    }

    public static void isPositiveInt(String count) {
        int result;

        try {
            result = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("회수는 정수만 입력 가능합니다.");
        }

        if (result <= 0) {
            throw new IllegalArgumentException("회수는 양의 정수만 입력 가능합니다.");
        }
    }
}
