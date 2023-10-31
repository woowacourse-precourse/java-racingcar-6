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
                if (decideCarMovement()) {
                    car.increaseCarDistance();
                }
                raceResultDisplay(car);
            }
            System.out.println();
            i++;
        }
    }

    public boolean decideCarMovement() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    public void raceResultDisplay(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getCarDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
