package racingcar;

import java.util.List;

public class Validator {

    public static void validateName(List<String> cars) {
        // 값이 없는 경우
        if (cars.size() == 0) {
            throw new IllegalArgumentException("값이 없는 경우");
        }

        // 중복 값이 존재하는 경우
        if(cars.size() != cars.stream().distinct().count()){
            throw new IllegalArgumentException("중복 값이 존재하는 경우");
        }

        String regex = "^[a-zA-Z0-9]{1,5}$";

        // 값의 길이가 5를 초과하는 경우
        for (String car : cars) {
           if(!car.matches(regex)) {
               throw new IllegalArgumentException("값의 길이가 5를 초과하는 경우");
           }
        }

    }

    public static void validateCount(String count) {
        String regex = "^[1-9]+$";

        if(!count.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
