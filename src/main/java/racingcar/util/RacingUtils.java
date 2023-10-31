package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class RacingUtils {

    public void showEnterMessage(String message) {
        System.out.println(message);
    }

    public boolean isRacingCarNameLength(String[] racingCars, int length) {
        for(String racingCar : racingCars) {
            if(racingCar.length() > length) {
                return false;
            }
        }

        return true;
    }
}
