package racingcar.game;

import racingcar.game.domain.Car;

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
        List<String> carNameList = StringSeparator.separate(carNames);
        setting.initializeCars(carNameList);
    }

    public void setRound(String round) {
        setting.initializeRound(round);
    }

    public List<String> raceOneRound() {
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
                winnerList.add(car.getName());
            } else if (maxDistance == carDistance){
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    public int upCurrentRound() {
        return ++currentRound;
    }

    public int getSettingRound() {
        return setting.getRound();
    }

}
