package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class RacingGame {

    private int raceCount;
    private int raceActionCount;
    private final List<Car> carList;
    private final List<String> winnerList;

    public RacingGame() {
        raceCount = 0;
        raceActionCount = 0;
        carList = new ArrayList<>();
        winnerList = new ArrayList<>();
    }

    public void setCarList(String carName) {
        List<String> separatedCarName = Arrays.asList(carName.split(","));
        for (String name : separatedCarName) {
            carList.add(new Car(name));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setRaceCount(String raceCount) {
        this.raceCount = Integer.parseInt(raceCount);
    }

    public int getRaceCount() {
        return this.raceCount;
    }

    public int getRaceActionCount() {
        return this.raceActionCount;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }


    public void startRace() {
        for (int i = 0; i < raceCount; i++, this.raceActionCount++) {
            decideCarPosition();
            sendRaceResult();
            notifyResultEnd();
        }
    }

    private void decideCarPosition() {
        for (Car car : carList) {
            car.setPosition(setRandomNumber());
        }
    }

    private int setRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void sendRaceResult() {
        for (Car car : carList) {
            GameController.showRaceResult(car.getName(), car.getPosition());
        }
    }

    private void notifyResultEnd() {
        GameController.markRaceEnd();
    }

    public void setWinnerList() {
        Collections.sort(carList, Collections.reverseOrder());
        for (Car car : carList) {
            if (carList.get(0).getPosition() == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
    }
}