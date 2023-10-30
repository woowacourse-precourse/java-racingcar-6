package racingcar.service;

import java.util.HashMap;
import java.util.List;
import racingcar.common.RandomGenerator;
import racingcar.model.RacingCarInfoList;

public class RacingCarService {
    private static final RacingCarService instance = new RacingCarService();

    public static RacingCarService getInstance() {
        return instance;
    }

    private RacingCarService() {
    }

    public HashMap<String, Integer> initRacingStatus(List<String> carNames) {
        HashMap<String, Integer> racingStatus = new HashMap<>();
        RacingCarInfoList racingCarList = new RacingCarInfoList(carNames);
        for (String carName : carNames) {
            racingStatus.put(carName, 0);
        }
        return racingStatus;
    }

    public void proceedGame(List<String> carNames, HashMap<String, Integer> racingStatus) {
        for (String carName : carNames) {
            Integer randomNumber = RandomGenerator.getRandomNumber();
            if (randomNumber > 3) {
                moveForward(carName, racingStatus);
            }
        }
    }

    private void moveForward(String carName, HashMap<String, Integer> racingStatus) {
        Integer carPosition = racingStatus.get(carName);
        racingStatus.put(carName, ++carPosition);
    }
}
