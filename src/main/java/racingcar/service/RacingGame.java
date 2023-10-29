package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.model.Car;

public class RacingGame {

    private static final int MIN_RANDOMNUMBER = 0;
    private static final int MAX_RANDOMNUMBER = 9;

    private int numberOfRaces;
    private int numberOfRaceRuns;
    private final List<Car> carList;
    private final List<String> winnerList;

    public RacingGame() {
        numberOfRaces = 0;
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

    public void setNumberOfRaces(String raceCount) {
        this.numberOfRaces = Integer.parseInt(raceCount);
    }

    public int getNumberOfRaces() {
        return this.numberOfRaces;
    }

    public int getNumberOfRaceRuns() {
        return this.numberOfRaceRuns;
    }

    public void setWinnerList() {
        Collections.sort(carList, Collections.reverseOrder());
        for (Car car : carList) {
            if (carList.get(0).getPosition() == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
    }

    public List<String> getWinnerList() {
        return winnerList;
    }

    public void startRace() {
        for (numberOfRaceRuns = 0; numberOfRaceRuns < numberOfRaces; numberOfRaceRuns++) {
            decideCarPosition();
            sendRaceResult();
        }
    }

    private void decideCarPosition() {
        for (Car car : carList) {
            car.setPosition(setRandomNumber());
        }
    }

    private int setRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOMNUMBER, MAX_RANDOMNUMBER);
    }

    private void sendRaceResult() {
        GameController.showRaceResult(carList);
    }
}