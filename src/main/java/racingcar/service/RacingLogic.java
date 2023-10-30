package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.PrintMessage;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class RacingLogic {

    public static void goRacing(RacingCars racingCars) {
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        for (RacingCar racingCar : racingCarList) {
            int randomNum = makeRandomNumber();
            isPlusDistance(randomNum, racingCar);
        }
        PrintMessage.printEnter();
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void isPlusDistance(int randomNum, RacingCar racingCar) {
        int distance = racingCar.getDistance();
        if (randomNum >= 4) {
            distance += 1;
            racingCar.setForwardDistance(distance);
        }
        setRacingDistance(racingCar);
    }

    public static void setRacingDistance(RacingCar racingCar) {
        String carName = racingCar.getRacingCarName();
        int distance = racingCar.getDistance();
        String distanceStr = "";
        for (int i = 0; i < distance; i++) {
            distanceStr += "-";
        }
        String result = carName + " : " + distanceStr;
        PrintMessage.printResult(result);
    }

    public static void determineRacingWinner(RacingCars racingCars) {
        int maxDistance = getMaxDistance(racingCars);
        List<String> winnerCarNames = new ArrayList<>();
        winnerCarNames = getWinnerCarName(racingCars, maxDistance);
        PrintMessage.printWinnerCarNames(winnerCarNames);
    }

    public static int getMaxDistance(RacingCars racingCars) {
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        int maxDistance = racingCarList.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElse(0);
        return maxDistance;
    }

    public static List<String> getWinnerCarName(RacingCars racingCars, int maxDistance) {
        List<String> winnerCarNames = new ArrayList<>();
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        for (RacingCar car : racingCarList) {
            if (car.getDistance() == maxDistance) {
                winnerCarNames.add(car.getRacingCarName());
            }
        }
        return winnerCarNames;
    }

}
