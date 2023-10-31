package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.common.RandomGenerator;
import racingcar.model.RacingCarList;

public class RacingCarService {
    private static final int MIN_NUMBER = 3;
    private static final int INITIAL_POSITION = 0;
    private static final RacingCarService instance = new RacingCarService();

    public static RacingCarService getInstance() {
        return instance;
    }

    private RacingCarService() {
    }

    public HashMap<String, Integer> initRacingStatus(List<String> carNames) {
        HashMap<String, Integer> racingStatus = new HashMap<>();
        RacingCarList racingCarList = new RacingCarList(carNames);
        for (String carName : carNames) {
            racingStatus.put(carName, INITIAL_POSITION);
        }
        return racingStatus;
    }

    public void proceedGame(List<String> carNames, HashMap<String, Integer> racingStatus) {
        for (String carName : carNames) {
            Integer randomNumber = RandomGenerator.getRandomNumber();
            if (randomNumber > MIN_NUMBER) {
                moveForward(carName, racingStatus);
            }
        }
    }

    private void moveForward(String carName, HashMap<String, Integer> racingStatus) {
        Integer carPosition = racingStatus.get(carName);
        racingStatus.put(carName, ++carPosition);
    }

    public List<String> getWinner(List<String> carNames, HashMap<String, Integer> racingStatus) {
        int maxDistance = Integer.MIN_VALUE;
        List<String> winnerList = new ArrayList<>();

        for (String carName : carNames) {
            if (racingStatus.get(carName) > maxDistance) {
                maxDistance = racingStatus.get(carName);
            }
        }

        for (String carName : carNames) {
            if (racingStatus.get(carName) == maxDistance) {
                winnerList.add(carName);
            }
        }

        return winnerList;
    }
}
