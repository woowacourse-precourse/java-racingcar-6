package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class RacingGame {

    private int raceCount;

    private final List<String> winnerList;

    public RacingGame() {
        winnerList = new ArrayList<>();
    }

    public List<String> getWinnerList() {
        return winnerList;
    }
    public void setRaceCount(String raceCount) {
        this.raceCount = Integer.parseInt(raceCount);
    }

    public void startRaceCount() {
        for (int i = 0; i < raceCount; i++) {
            setCarPosition();
            printCarPosition();
        }

    }

    private void setCarPosition() {
        for (Car car : Car.carList) {
            int randomNumber = setRandomNumber();
            if (randomNumber >= 4) {
                car.setPosition(1);
            }
        }
    }

    private int setRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printCarPosition() {
        for (Car car : Car.carList) {
            OutputView.printCarPosition(car.getName(), car.getPosition());
        }
        OutputView.divideRace();
    }

    public void selectWinner() {
        //List<String> winnerList = new ArrayList<>();
        Collections.sort(Car.carList, Collections.reverseOrder());
        /*
        for (Car e : Car.carList) {
            System.out.println(e.getName() + e.getPosition());
        }

         */
        for (Car car : Car.carList) {
            if (Car.carList.get(0).getPosition() == car.getPosition()) {
                //List<String> winnerList = new ArrayList<>();
                winnerList.add(car.getName());
            }
        }
        /*
        for (String e : winnerList) {
            System.out.println(e);
        }
         */
    }
}