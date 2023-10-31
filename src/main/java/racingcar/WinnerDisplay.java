package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerDisplay {
//    private RaceInfo raceInfo;

//    public WinnerDisplay(RaceInfo raceInfo) {
//        this.raceInfo = raceInfo;
//        winnerPrint(verifyWinner());
//    }

    public static List<String> verifyWinner(RaceInfo raceInfo) {
        int maxCarDistance = 0;
        List<String> winnerCarName = new ArrayList<>();
        for (Car car : raceInfo.getCarList()) {
            int carDistance = car.getCarDistance();
            if (carDistance > maxCarDistance) {
                maxCarDistance = carDistance;
            }
        }
        for (Car car : raceInfo.getCarList()) {
            if (car.getCarDistance() == maxCarDistance) {
                winnerCarName.add(car.getName());
            }
        }
        return winnerCarName;
    }

    public static void winnerPrint(List<String> winnerCarName) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winnerCarName);
        System.out.print(result);
    }


}
