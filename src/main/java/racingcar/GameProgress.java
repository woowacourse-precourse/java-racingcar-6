package racingcar;

import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class GameProgress {

    public static void racing(Map<String, String> carNamesMap, int attemptNumber) {
        for (int index = 0; index < attemptNumber; index++) {
            for (String carName : carNamesMap.keySet()) {
                carMove(carNamesMap, carName);
                System.out.println(carName + " :" + carNamesMap.get(carName));
            }
            OutputView.printWordSpacing();
        }
    }

    private static void carMove(Map<String, String> carNamesMap, String carName) {
        if (generateRandomNumber()) {
            String carValue = carNamesMap.get(carName);
            carValue += "-";
            carNamesMap.put(carName, carValue);
        }
    }

    private static boolean generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
