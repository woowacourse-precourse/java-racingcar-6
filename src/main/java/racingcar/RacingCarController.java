package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {

    private static List<RacingCar> racingCarList;

    public static void setRacingCarList(List<RacingCar> _racingCarList) {
        racingCarList = _racingCarList;
    }

    public static RacingCar registerRacingCar(String name) {
        RacingCar newRacingCar = new RacingCar(name, 0);
        racingCarList.add(newRacingCar);
        return newRacingCar;
    }

    public static void updateRacingCar(RacingCar racingCar) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            racingCar.updateLocation();
        }
    }

    public static List<RacingCar> findWinner() {
        int highScore = 0;
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar rc : racingCarList) {
            if (rc.getLocation() > highScore) {
                highScore = rc.getLocation();
                winners.clear();
                winners.add(rc);
                continue;
            }
            if (rc.getLocation() == highScore) {
                winners.add(rc);
            }
        }

        return winners;
    }
}
