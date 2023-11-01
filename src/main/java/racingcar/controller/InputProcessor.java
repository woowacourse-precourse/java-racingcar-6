package racingcar.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Processes string input
 *
 * @author WorldBestProgrammer
 */
public class InputProcessor {

    /**
     * Checks errors with car name string input and returns the processed
     *
     * @param userCarInput Car name input
     * @return The list of car names
     */
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

            boolean uniqueFlag = userCars.add(userCar);
            if (!uniqueFlag) {
                throw new IllegalArgumentException("중복은 허용되지 않습니다.");
            }
        }

        return userCars.stream().toList();
    }

    /**
     * Checks errors with total round string input and returns the processed
     *
     * @param totalRoundInput Total round input
     * @return Integer value of total round
     */
    public static int totalRoundInputProcessor(String totalRoundInput) {
        try {
            return Integer.parseInt(totalRoundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
