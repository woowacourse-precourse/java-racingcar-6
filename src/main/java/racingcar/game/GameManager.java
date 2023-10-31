package racingcar.game;

import racingcar.game.domain.Car;
import racingcar.game.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final GameSetting setting;
    private int currentRound;

    public GameManager() {
        this.setting = new GameSetting();
        currentRound = 0;
    }

    public void setCars(String carNames) {
        List<String> carNameList = StringUtil.separate(carNames);
        setting.initializeCars(carNameList);
    }

    public void setRound(String round) {
        int movingCount = StringUtil.makeInteger(round);
        setting.initializeRound(movingCount);
    }

    public List<String> raceOneRound() {
        upCurrentRound();
        setting.tryCarsForward();
        return setting.getCarsState();
    }

    public List<String> findWinners() {
        List<Car> cars = setting.getCars();
        List<String> winnerList = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            int carDistance = car.getForwardState().length();
            if (maxDistance < carDistance) {
                maxDistance = carDistance;
                winnerList.clear();
            }
            if (maxDistance == carDistance) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    public Boolean isGameOngoing() {
        return (setting.getRound() > currentRound);
    }

    private void upCurrentRound() {
        ++currentRound;
    }

}
