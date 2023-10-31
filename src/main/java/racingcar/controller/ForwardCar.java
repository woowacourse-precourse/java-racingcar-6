package racingcar.controller;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class ForwardCar {
    public static Map<String, Integer> forwardCar(Map<String, Integer> racingCar) {
        for (String carName : racingCar.keySet()) {
            if (Randoms.pickNumberInRange(1, 9) >= 4) {
                racingCar.put(carName, racingCar.get(carName) + 1);
            }
        }
        return racingCar;
    }
}
