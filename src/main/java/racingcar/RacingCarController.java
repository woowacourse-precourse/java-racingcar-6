package racingcar;

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
}
