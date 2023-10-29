package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGameManager {
    private RacingCarList racingCarList;
    private User user;

    public RacingGameManager(RacingCarList racingCarList, User user) {
        this.racingCarList = racingCarList;
        this.user = user;
    }

    public List<RacingCar> raceCars() {
        int RacingCount = getRacingCount();

        for (int i = 0; i < RacingCount; i++) {
            moveCarsBasedOnRandomNumber();
            printCarsCurrentPosition();
            System.out.println();
        }
        return getRacingCarList();
    }

    private void printCarsCurrentPosition() {
        for (RacingCar car : getRacingCarList()) {
            car.printCurrentPositionWithName();
        }
    }

    private void moveCarsBasedOnRandomNumber() {
        List<RacingCar> enrolledCarsToRace = getRacingCarList();

        for (int i = 0; i < enrolledCarsToRace.size(); i++) {
            int movingForwardNumber = Randoms.pickNumberInRange(0, 9);
            moveCarsIfAllow(movingForwardNumber, i);
        }

    }

    private void moveCarsIfAllow(int movingForwardNumber, int i) {
        if (canForward(movingForwardNumber)) {
            getRacingCarList().get(i).move();
        }
    }

    private boolean canForward(int movingForwardNumber) {
        return movingForwardNumber >= 4;
    }

    private List<RacingCar> getRacingCarList() {
        return racingCarList.getRacingCarList();
    }

    private int getRacingCount() {
        return Integer.parseInt(user.runRaceBasedOnInput());
    }
}
