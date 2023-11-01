package racingcar.util;

import java.util.List;

public class InputUtil {
    public static String[] splitCarName(String carName) {
        return validateCarName(carName);
    }

    private static String[] validateCarName(String carName) {
        String[] carNameStrings = carName.split(",");

        for (String carNameStr : carNameStrings) {
            if (carNameStr.length() > 5 || carNameStr.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
            }
        }

        return carNameStrings;
    }

    public static int getRaceLap(String raceLap) {
        return validateRaceLap(raceLap);
    }

    private static int validateRaceLap(String raceLap) {
        int lap;

        try {
            lap = Integer.parseInt(raceLap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("랭킹 수는 숫자만 입력 가능하다.");
        }
        
        if (lap <= 0) {
            throw new IllegalArgumentException("랭킹 수는 1 이상의 정수만 입력 가능하다.");
        }

        return lap;
    }
}
