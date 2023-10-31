package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarMove {
    private RaceInfo raceInfo;


    public CarMove(RaceInfo raceInfo) {
        this.raceInfo = raceInfo;
        carRace();
    }

    public void carRace() {
        System.out.println("실행 결과");
        int i = 1;
        while (i <= raceInfo.getAttemptCount()) {
            for (Car car : raceInfo.getCarList()) {
                if (decideCarMovement()){
                    car.increaseCarDistance();
                }
                RaceResultView.raceResultDisplay(car);
            }
            System.out.println();
            i++;
        }
    }

    public static boolean decideCarMovement() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
