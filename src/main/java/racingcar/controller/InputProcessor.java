package racingcar.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InputProcessor {

    public static List<String> userCarInputProcessor(String userCarInput) {
        String[] userCarsInputs = userCarInput.split(",\\s*");
        Set<String> userCars = new LinkedHashSet<>();

        if (userCarsInputs.length == 0) {
            throw new IllegalArgumentException("하나 이상의 이름을 적으셔야 합니다.");
        }
        for (String userCar : userCarsInputs) {

            if (userCar.isEmpty() || userCar.length() > 5) {

                throw new IllegalArgumentException("길이는 1 이상 5 이하여야 합니다");

            }

            if (!userCars.add(userCar)) {
                throw new IllegalArgumentException("중복은 허용되지 않습니다.");
            }

        }

        return userCars.stream().toList();
    }

    public static int totalRoundInputProcessor(String totalRoundInput) {
        try {

            return Integer.parseInt(totalRoundInput);

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");

        }

    }

}
