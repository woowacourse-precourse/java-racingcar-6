package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    public boolean isForward() {
        RandomNumber randomNumber = new RandomNumber();
        int number = randomNumber.createRandom();
        if (number >= 4) {
            return true;
        }
        return false;
    }

    public Map<String, Integer> racing(List<String> carNames, int moveCount) {

        Race T = new Race();
        int carCount = carNames.size();
        Map<String, Integer> raceResult = new HashMap<String, Integer>();
        for(int i=0; i<carCount; i++) {
            raceResult.put(carNames.get(i), 0);
        }
        Map<String, String> carStatus = new HashMap<String, String>();
        for (int j =0; j<carCount; j++) {
            carStatus.put(carNames.get(j), "");
        }
        for (int k=0; k<moveCount; k++) {
            for (int carIndex = 0; carIndex < carCount; carIndex++) {
                String carName = carNames.get(carIndex);
                if (T.isForward()) {
                    raceResult.replace(carName, raceResult.get(carName) + 1);
                    carStatus.replace(carName, carStatus.get(carName) + "-");
                }
                System.out.println(carName + " : " + carStatus.get(carName));
            }
            System.out.print("\n");
        }

        return raceResult;
    }
}
