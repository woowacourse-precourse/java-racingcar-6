package racingcar;

import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class GameProgress {

    public static void racing(Map<String, String> racingCars, int attemptNumber) {
        for (int index = 0; index < attemptNumber; index++) {
            for (String carName : racingCars.keySet()) {
                movingCar(racingCars, carName);
                System.out.println(carName + " :" + racingCars.get(carName));
            }
            OutputView.printEnter();
        }
    }

    private static void movingCar(Map<String, String> racingCars, String carName) {
        if (generateRandomNumber()) {
            String carDistance = racingCars.get(carName);
            carDistance += "-";
            racingCars.put(carName, carDistance);
        }
    }

    private static boolean generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
